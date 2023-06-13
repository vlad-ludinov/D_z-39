package Service;

import java.util.Collections;
import java.util.List;

import Model.Teacher;
import Repository.TeacherRepository;
import Repository.UserRepository;

public class TeacherService implements UserService<Teacher> {

    private final UserRepository<Teacher> teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        Long id = teacherRepository.getMaxId() + 1;
        Teacher teacher = new Teacher(id, fullName, age, phoneNumber);
        teacherRepository.add(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.getAll();    
    }

    @Override
    public List<Teacher> getAllSortUsers() {
        List<Teacher> teachers = teacherRepository.getAll();
        Collections.sort(teachers);
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortUsersBySurname() {
        List<Teacher> teachers = teacherRepository.getAll();
        teachers.sort(new UserComporator<>());
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortUsersByAge() {
        List<Teacher> students = teacherRepository.getAll();
        students.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        return students;
    }

    @Override
    public void removeUser(String fullName) {
        teacherRepository.remove(fullName);
    }
    
}
