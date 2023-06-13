package Model;

public class User {
    
    private final Long id;
    private final String fullName;
    private final Integer age;
    private final String phoneNumber;

    public User(Long id, String fullName, Integer age, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
