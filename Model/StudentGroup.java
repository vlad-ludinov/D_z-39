package Model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Service.StudentGroupIterator;
import Service.UserComporator;

//@Data
public class StudentGroup implements Iterable<Student> {

    private final List<Student> studentsList;

    public StudentGroup() {
        studentsList = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(studentsList);
    }


    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public String toString() {
        String res = "";
        for (Student student : studentsList) {
            res += String.format("%s\n", student);
        }
        return res;
    }

    public void sortName() {
        Collections.sort(studentsList);
    }

    public void sortSurname() {
        studentsList.sort(new UserComporator<Student>());
    }
}
