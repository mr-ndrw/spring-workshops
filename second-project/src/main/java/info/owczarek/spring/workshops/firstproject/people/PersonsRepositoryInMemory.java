package info.owczarek.spring.workshops.firstproject.people;

import java.util.HashMap;
import java.util.Map;

public class PersonsRepositoryInMemory implements PersonsRepository {
    private Map<Long, Person> persons = new HashMap<>();

    public Person save(Person person) {
        return persons.put(person.getPesel(), person);
    }

    public Person findOne(Long pesel) {
        return persons.get(pesel);
    }

    public Iterable<Person> findAll() {
        return persons.values();
    }

    public long count() {
        return persons.size();
    }
}
