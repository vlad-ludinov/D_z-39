package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Teacher;

public class TeacherRepository implements UserRepository<Teacher> {

    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void remove(String fullName) {
        for (Teacher teacher : teachers) {
            if (teacher.getFullName().equals(fullName)) {
                teachers.remove(teacher);
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getId() > maxId) {
                maxId = teacher.getId();
            }
        }
        return maxId;
    }

    @Override
    public Teacher getUser(String fullName) {
        for (Teacher teacher : teachers) {
            if (teacher.getFullName().equals(fullName)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> getRandom(Integer num) {
        List<Teacher> selectedTeacher = new ArrayList<>();
        Random rand = new Random();
        Teacher teach;
        if (teachers.size() < num) {
            num = teachers.size();
        }
        while (selectedTeacher.size() < num) {
            teach = teachers.get(rand.nextInt(0, teachers.size()));
            if (!selectedTeacher.contains(teach)) {
                selectedTeacher.add(teach);
            }
        }
        return selectedTeacher;
    }

}
