import Controller.StudentController;
import Repository.StudentRepository;
import Service.StudentService;
import View.SortType;
import View.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView view = getStudentView();

//----------------------------------------------------------------------
        view.create("aab bab", 19, "999");
        view.create("aaa abb", 20, "999");
        view.create("aba bba", 18, "999");
        view.create("bba bbb", 18, "999");
        view.create("abb aaa", 21, "999");
        view.create("bab baa", 45, "999");
        view.create("baa aab", 19, "999");
        view.create("bbb aba", 7, "999");
        view.sendOnConsole(SortType.NONE);
        view.sendOnConsole(SortType.NAME);
        view.sendOnConsole(SortType.FAMILY);
        view.sendOnConsole(SortType.AGE);
        


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

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }
    
}

