package Controller;

import java.util.List;

import Model.User;

/**
 * UserController
 */
public interface UserController<T extends User> {

    void create(String fullName, Integer age, String phoneNumber);

    List<T> getAll();
    
    List<T> getAllSortUsers();

    List<T> getAllSortUsersBySurname();

    List<T> getAllSortUsersByAge();

    boolean removeUser(String fullName);
}