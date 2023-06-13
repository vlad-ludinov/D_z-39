package Repository;

import java.util.List;

import Model.User;

public interface UserRepository<T extends User> {
    
    List<T> getAll();

    T getUser(String fullName);

    void add(T t);

    void remove(String fullName);

    Long getMaxId();
}
