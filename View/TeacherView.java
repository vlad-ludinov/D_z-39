package View;

import java.util.List;

import Controller.TeacherController;
import Controller.UserController;
import Model.Teacher;

public class TeacherView implements UserView<Teacher> {

    UserController<Teacher> controller;

    public TeacherView(TeacherController controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(String sortType) {
        List<Teacher> teachers = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.NAME -> controller.getAllSortUsers();
            case SortType.FAMILY -> controller.getAllSortUsersBySurname();
            case SortType.AGE -> controller.getAllSortUsersByAge();
            default -> null;
        };
        if (teachers == null) {
            return;
        }
        System.out.println("===================================");        
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("===================================");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        controller.create(fullName, age, phoneNumber);
    }

    @Override
    public void removeUser(String fullName) {
        controller.removeUser(fullName);
    }
    
}
