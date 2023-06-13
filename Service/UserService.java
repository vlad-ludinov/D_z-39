package Service;

import java.util.List;

import Model.User;

public interface UserService<T extends User> {
    
    void create(String fullName, Integer age, String phoneNumber);

    List<T> getAll();

    List<T> getAllSortUsers();

    List<T> getAllSortUsersBySurname();

    List<T> getAllSortUsersByAge();


    void removeUser(String fullName);
}


