package Service;

import java.util.Collections;
import java.util.List;

import Model.Student;
import Model.StudyGroup;
import Model.Teacher;

public class StudyGroupService {
    
    private StudyGroup studyGroup;

    public StudyGroupService(String groupName, Integer size) {
        this.studyGroup = new StudyGroup(groupName, size);
    }

    public boolean formingGroup(Teacher teacher, List<Student> students) {
        studyGroup.setTeacher(teacher);
        studyGroup.removeAllStudents();
        for (Student student : students) {
            if (studyGroup.getStudents().size() < studyGroup.getSize()) {
                studyGroup.addStudent(student);
            } else {
                return false;
            }   
        }
        return true;
    }

    public boolean removeStudent(Student student) {
        return studyGroup.removeStudent(student);
    }

    public void replaceTeacher(Teacher teacher) {
        studyGroup.setTeacher(teacher);
    }

    public boolean addStudent(Student student) {
        if (studyGroup.getStudents().size() < studyGroup.getSize()) {
            studyGroup.addStudent(student);
            return true;
        } else {
            return false;
        }
    }

    public StudyGroup getAll() {
        return studyGroup;
    }
    
    public StudyGroup getAllSortUsers() {
        List<Student> students = studyGroup.getStudents();
        Collections.sort(students);
        studyGroup.removeAllStudents();
        for (Student student : students) {
            studyGroup.addStudent(student);
        }
        return studyGroup;
    }

    public StudyGroup getAllSortUsersBySurname() {
        List<Student> students = studyGroup.getStudents();
        students.sort(new UserComporator<>());
        studyGroup.removeAllStudents();
        for (Student student : students) {
            studyGroup.addStudent(student);
        }
        return studyGroup;
    }

    public StudyGroup getAllSortUsersByAge() {
        List<Student> students = studyGroup.getStudents();
        students.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        studyGroup.removeAllStudents();
        for (Student student : students) {
            studyGroup.addStudent(student);
        }
        return studyGroup;
    }
}
