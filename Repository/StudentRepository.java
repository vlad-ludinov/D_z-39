package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Student;

public class StudentRepository implements UserRepository<Student>{

    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void remove(String fullName) {
        for (Student student : students) {
            if (student.getFullName().equals(fullName)) {
                students.remove(student);
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = 0L;
        for (Student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;
    }

    @Override
    public Student getUser(String fullName) {
        for (Student student : students) {
            if (student.getFullName().equals(fullName)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getRandom(Integer num) {
        List<Student> selectedStudents = new ArrayList<>();
        Random rand = new Random();
        Student stud;
        if (students.size() < num) {
            num = students.size();
        }
        while (selectedStudents.size() < num) {
            stud = students.get(rand.nextInt(0, students.size()));
            if (!selectedStudents.contains(stud)) {
                selectedStudents.add(stud);
            }
        }
        return selectedStudents;
    }

}

