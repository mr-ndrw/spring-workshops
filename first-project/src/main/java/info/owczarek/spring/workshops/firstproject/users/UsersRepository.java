package info.owczarek.spring.workshops.firstproject.users;

public interface UsersRepository {
    User save(User user);

    User findOne(Long id);

    Iterable<User> findAll();

    long count();
}
