package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Service.StudyGroupIterator;

//@Data
public class StudyGroup implements Iterable<Student> {

    private String groupName;
    private Integer size;
    private Teacher teacher;
    private List<Student> students;

    public StudyGroup(String groupName, Integer size) {
        this.groupName = groupName;
        this.size = size;
        students = new ArrayList<>();
    }



    
    
    @Override
    public Iterator<Student> iterator() {
        return new StudyGroupIterator(students);
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getGroupName() {
        return groupName;
    }

    public Integer getSize() {
        return size;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(Student student) {
        // if (students.contains(student)) {
        //     students.remove(students.indexOf(student));
        //     return true;
        // }
        // return false;
        return students.remove(student);
    }

    public void removeAllStudents() {
        Integer currentSize = students.size();
        for (int i = 0; i < currentSize; i++) {
            students.remove(0);
        }
    }


    @Override
    public String toString() {
        String res = String.format("Group %s\n Teacher:\n  %s\n Students:\n", groupName, teacher);
        for (Student student : students) {
            res += String.format("  %s\n", student);
        }
        return res;
    }

}
