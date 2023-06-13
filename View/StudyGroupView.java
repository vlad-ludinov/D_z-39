package View;

import Controller.StudentController;
import Controller.StudyGroupController;
import Controller.TeacherController;
import Model.StudyGroup;

public class StudyGroupView {
    
    private final StudyGroupController controller;
    private final StudentController studentController;
    private final TeacherController teacherController;

    public StudyGroupView(StudyGroupController controller, StudentController studentController, TeacherController teacherController) {
        this.controller = controller;
        this.studentController = studentController;
        this.teacherController = teacherController;
    
    }

    public void SendOnConsole(String sortType) {
        StudyGroup group = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.NAME -> controller.getAllSortUsers();
            case SortType.FAMILY -> controller.getAllSortUsersBySurname();
            case SortType.AGE -> controller.getAllSortUsersByAge();
            default -> null;
        };
        if (group == null) {
            return;
        }

        System.out.println("======================================");
        System.out.println(group);
        System.out.println("======================================");

    }

    public void formingGroup(String fullNameTeacher) {
        if (controller.formingGroup(teacherController.getUser(fullNameTeacher), studentController.getAll())) {
            System.out.println("Group formed");
        } else {
            System.out.println("Group formed. Place into the group are over");
        }

    }

    public void removeStudent(String fullName) {
        if (controller.removeStudent(studentController.getUser(fullName))) {
            System.out.println("Student remove from group");
        } else {
            System.out.println("Student not in the group");
        }
    }

    public void replaceTeacher(String fullName) {
        controller.replaceTeacher(teacherController.getUser(fullName));
        System.out.println("Teacher change");
    }

    public void addStudent(String fullName) {
        if (controller.addStudent(studentController.getUser(fullName))) {
            System.out.println("Student added to group");
        } else {
            System.out.println("Group is full");
        }
    }

}
