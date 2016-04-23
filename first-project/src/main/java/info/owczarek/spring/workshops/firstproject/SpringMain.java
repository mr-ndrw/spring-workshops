package info.owczarek.spring.workshops.firstproject;

import info.owczarek.spring.workshops.firstproject.people.Person;
import info.owczarek.spring.workshops.firstproject.people.PersonsRepository;
import info.owczarek.spring.workshops.firstproject.taxes.TaxService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by andrew on 23.04.2016.
 */
public class SpringMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PersonsRepository personRepository = context.getBean("personRepository", PersonsRepository.class);

        Person person = new Person();
        int pesel = 111111;
        person.setPesel(pesel);
        person.setFirstName("Jan");
        person.setLastName("Kowalski");
        person.setAge(21);
        person.setIncome(1000.0);
        personRepository.save(person);
        System.out.println(personRepository.count());

        TaxService taxService = context.getBean(TaxService.class);

        System.out.println(taxService.getTax(pesel));

    }
}
