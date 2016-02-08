package info.owczarek.spring.workshops.firstproject.people;

public interface PersonsRepository {
    Person save(Person person);

    Person findOne(Long pesel);

    Iterable<Person> findAll();

    long count();
}
