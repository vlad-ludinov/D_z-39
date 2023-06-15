package Controller;

import java.util.List;

import Model.Student;
import Model.StudyGroup;
import Model.Teacher;
import Service.StudyGroupService;

public class StudyGroupController {

    private StudyGroupService service;

    public StudyGroupController(StudyGroupService service) {
        this.service = service;
    }

    public boolean formingGroup(Teacher teacher, List<Student> students) {
        return service.formingGroup(teacher, students);
    }

    public boolean removeStudent(Student student) {
        return service.removeStudent(student);
    }

    public boolean replaceTeacher(Teacher teacher) {
        return service.replaceTeacher(teacher);
    }

    public boolean addStudent(Student student) {
        return service.addStudent(student);
    }

    public StudyGroup getAll() {
        return service.getAll();
    }

    public StudyGroup getAllSortUsers() {
        return service.getAllSortUsers();
    }

    public StudyGroup getAllSortUsersBySurname() {
        return service.getAllSortUsersBySurname();
    }

    public StudyGroup getAllSortUsersByAge() {
        return service.getAllSortUsersByAge();
    }
}
