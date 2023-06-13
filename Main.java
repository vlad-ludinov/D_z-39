import Controller.StudentController;
import Controller.StudyGroupController;
import Controller.TeacherController;
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
        StudentController studentController = getStudentController();
        TeacherController teacherController = getTeacherController();
        StudyGroupController studyGroupController = getStudyGroupController();
        StudyGroupView studyGroupView = new StudyGroupView(studyGroupController, studentController, teacherController);
        StudentView studentsView = new StudentView(studentController);
        TeacherView teacherView = new TeacherView(teacherController);

//----------------------------------------------------------------------
        // studentsView.create("aab bab", 19, "999");
        // studentsView.create("aaa abb", 20, "999");
        // studentsView.create("aba bba", 18, "999");
        // studentsView.create("bba bbb", 18, "999");
        // studentsView.create("abb aaa", 21, "999");
        // studentsView.create("bab baa", 45, "999");
        // studentsView.create("baa aab", 19, "999");
        // studentsView.create("bbb aba", 7, "999");
        // studentsView.sendOnConsole(SortType.NONE);
        // studentsView.sendOnConsole(SortType.NAME);
        // studentsView.sendOnConsole(SortType.FAMILY);
        // studentsView.sendOnConsole(SortType.AGE);
    
        
        teacherView.create("aaa bbb", 100, "999");
        teacherView.create("bbb ccc", 100, "999");
        for (int i = 0; i < 30; i++) {
            studentsView.create((String.format("student%s surname%s", i, (29 - i))), 10, "000");
        }
        studyGroupView.formingGroup("aaa bbb");
        // studentsView.removeUser("student1 surname28");
        studyGroupView.SendOnConsole(SortType.NONE);
        studyGroupView.replaceTeacher("bbb ccc");
        studyGroupView.addStudent("student29 surname0");
        studyGroupView.removeStudent("student3 surname26");
        studyGroupView.SendOnConsole(SortType.FAMILY);
        
        studyGroupView.SendOnConsole(SortType.NAME);






        // controller.addStudent(new Student(8L, "Acna Aorozova"));
        // controller.addStudent(new Student(8L, "Anna Eobozova"));
        // controller.addStudent(new Student(8L, "Abna Corozova"));
        // controller.addStudent(new Student(8L, "Anba Borozova"));
        // controller.addStudent(new Student(8L, "Atna dorozova"));
        // controller.addStudent(new Student(8L, "Anaa Eoaozova"));
        // controller.addStudent(new Student(8L, "Ann Morozov"));
        // controller.addStudent(new Student(8L, "Anna Morozova"));
        // controller.addStudent(new Student(8L, "Бнна Дорозова"));
        // controller.addStudent(new Student(8L, "Снна Борозова"));
        // controller.addStudent(new Student(8L, "Абна Аорозова"));
        // controller.addStudent(new Student(8L, "Аана Мовозова"));
        // controller.addStudent(new Student(8L, "Анн Моабзова"));
        // controller.addStudent(new Student(8L, "Аннаа Моаазова"));
        // controller.addStudent(new Student(8L, "Аёна Морожова"));
        // controller.addStudent(new Student(8L, "Аена Мороеова"));
        // controller.addStudent(new Student(8L, "Ажна МороЁова"));


        

        

        


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

    private static StudyGroupController getStudyGroupController() {
        StudyGroupService service = new StudyGroupService("arrc12", 10);
        return new StudyGroupController(service);
    }
    
}

