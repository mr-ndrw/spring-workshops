package info.owczarek.spring.workshops.firstproject;

import info.owczarek.spring.workshops.firstproject.people.Person;
import info.owczarek.spring.workshops.firstproject.people.PersonsRepository;
import info.owczarek.spring.workshops.firstproject.taxes.TaxService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        PersonsRepository personsRepository
                = context.getBean("personsRepository", PersonsRepository.class);

        System.out.println("Liczba osób: " + personsRepository.count());

        Person person = new Person();
        person.setPesel(12345);
        person.setFirstName("Jan");
        person.setLastName("Nowak");
        person.setAge(23);
        person.setIncome(1000.0);

        personsRepository.save(person);

        System.out.println("Liczba osób: " + personsRepository.count());

        TaxService taxService = context.getBean(TaxService.class);
        double tax = taxService.getTax(12345);
        System.out.println("Podatek do zapłacenia: " + tax);

    }
}
