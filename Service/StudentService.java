package Service;

import java.util.Collections;
import java.util.List;

import Model.Student;
import Repository.StudentRepository;
import Repository.UserRepository;

public class StudentService implements UserService<Student>{

    private final UserRepository<Student> studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        Long id = studentRepository.getMaxId() + 1;
        Student student = new Student(id, fullName, age, phoneNumber);
        studentRepository.add(student);

    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }
    
    @Override
    public List<Student> getAllSortUsers() {
        List<Student> students = studentRepository.getAll();
        Collections.sort(students);
        return students;
    }

    @Override
    public List<Student> getAllSortUsersBySurname() {
        List<Student> students = studentRepository.getAll();
        students.sort(new UserComporator<>());
        return students;
    }

    @Override
    public List<Student> getAllSortUsersByAge() {
        List<Student> students = studentRepository.getAll();
        students.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        return students;
    }

    @Override
    public void removeUser(String fullName) {
        studentRepository.remove(fullName);
    }

    
}
