package Service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Model.Student;

public class StudyGroupIterator implements Iterator<Student> {

    private final List<Student> studentList;
    private int position;

    public StudyGroupIterator(List<Student> studentsList) {
        this.studentList = studentsList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public void remove() {
        studentList.remove(--position);
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studentList.get(position++);
    }
}
