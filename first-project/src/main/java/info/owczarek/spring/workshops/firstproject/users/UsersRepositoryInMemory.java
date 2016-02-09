package info.owczarek.spring.workshops.firstproject.users;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryInMemory implements UsersRepository {
    private Map<Long, User> users = new HashMap<>();

    public User save(User user) {
        return users.put(user.getId(), user);
    }

    public User findOne(Long id) {
        return users.get(id);
    }

    public Iterable<User> findAll() {
        return users.values();
    }

    public long count() {
        return users.size();
    }
}
