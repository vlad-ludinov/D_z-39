package View;

import Model.User;

public interface UserView<T extends User> {
    
    void sendOnConsole(String sortType);
    void create(String fullName, Integer age, String phoneNumber);
    void removeUser(String fullName);

}
