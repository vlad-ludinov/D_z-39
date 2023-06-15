import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controller.StudentController;
import Controller.StudyGroupController;
import Controller.TeacherController;
import Model.Student;
import Repository.StudentRepository;
import Repository.TeacherRepository;
import Service.StudentService;
import Service.StudyGroupService;
import Service.TeacherService;
import View.SortType;
import View.StudentView;
import View.StudyGroupView;
import View.TeacherView;

public class Main {
    
    
    public static void main(String[] args) {

        List<Object> views = preparation("arc11", 10);
        StudyGroupView studyGroupView = (StudyGroupView)views.get(0);
        StudentView studentsView = (StudentView)views.get(1);
        TeacherView teacherView = (TeacherView)views.get(2);
        // ----------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            teacherView.create((String.format("teacher%s surname%s", i, new Random().nextInt(0, 11))),
            new Random().nextInt(40, 51), "999");
        }
        for (int i = 0; i < 20; i++) {
            studentsView.create((String.format("student%s surname%s", i, new Random().nextInt(0, 11))),
                    new Random().nextInt(18, 26), "000");
        }
        studyGroupView.formingGroup(15);
        studyGroupView.SendOnConsole(SortType.NONE);
        studyGroupView.replaceTeacher("bbb ccc");
        studyGroupView.addStudent("student29 surname0");
        studyGroupView.SendOnConsole(SortType.FAMILY);
        studyGroupView.removeStudent("student0 surname19");
        studyGroupView.SendOnConsole(SortType.NAME);
        studyGroupView.formingGroup(5);
        studyGroupView.addStudent("");


    }

    private static List<Object> preparation(String groupName, Integer size) {
        StudentController studentController = getStudentController();
        TeacherController teacherController = getTeacherController();
        StudyGroupController studyGroupController = getStudyGroupController(groupName, size);
        StudyGroupView studyGroupView = new StudyGroupView(studyGroupController, studentController, teacherController);
        StudentView studentsView = new StudentView(studentController);
        TeacherView teacherView = new TeacherView(teacherController);
        List<Object> views = new ArrayList<>();
        views.add(studyGroupView);
        views.add(studentsView);
        views.add(teacherView);
        return views;
    }

    private static StudentController getStudentController() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        return new StudentController(service);
    }

    private static TeacherController getTeacherController() {
        TeacherRepository repository = new TeacherRepository();
        TeacherService service = new TeacherService(repository);
        return new TeacherController(service);
    }

    private static StudyGroupController getStudyGroupController(String groupName, Integer size) {
        StudyGroupService service = new StudyGroupService(groupName, size);
        return new StudyGroupController(service);
    }

}
