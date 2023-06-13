package Controller;

import java.util.List;

import Model.Teacher;
import Service.TeacherService;
import Service.UserService;

public class TeacherController implements UserController<Teacher> {

    private UserService<Teacher> teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        teacherService.create(fullName, age, phoneNumber);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @Override
    public List<Teacher> getAllSortUsers() {
        return teacherService.getAllSortUsers();        
    }

    @Override
    public List<Teacher> getAllSortUsersBySurname() {
        return teacherService.getAllSortUsersBySurname();
    }

    @Override
    public List<Teacher> getAllSortUsersByAge() {
        return teacherService.getAllSortUsersByAge();
    }

    @Override
    public boolean removeUser(String fullName) {
        teacherService.removeUser(fullName);
        return true;
    }
    
}
