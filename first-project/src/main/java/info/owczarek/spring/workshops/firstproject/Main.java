package info.owczarek.spring.workshops.firstproject;

import info.owczarek.spring.workshops.firstproject.people.Person;
import info.owczarek.spring.workshops.firstproject.people.PersonsRepository;
import info.owczarek.spring.workshops.firstproject.people.PersonsRepositoryInMemory;
import info.owczarek.spring.workshops.firstproject.taxes.TaxServiceIn2015;

public class Main {
    public static void main(String[] args) {
        PersonsRepository personsRepository = new PersonsRepositoryInMemory();
        Person person = new Person();
        int pesel = 111111;
        person.setPesel(pesel);
        person.setFirstName("Jan");
        person.setLastName("Kowalski");
        person.setAge(21);
        person.setIncome(1000.0);
        personsRepository.save(person);
        System.out.println(personsRepository.count());

        TaxServiceIn2015 taxService = new TaxServiceIn2015();
        taxService.setPersonsRepository(personsRepository);
        taxService.setFlatTaxLevel(0.19);
        double tax = taxService.getTax(pesel);
        System.out.println("Podatek dla osoby: " + tax);
    }
}
