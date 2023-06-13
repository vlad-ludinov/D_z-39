package Repository;

import java.util.List;

import Model.User;

public interface UserRepository<T extends User> {
    
    List<T> getAll();

    void add(T t);

    void remove(String s);

    Long getMaxId();
}
