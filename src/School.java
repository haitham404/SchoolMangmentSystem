import java.util.*;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private Map<Student, List<Course>> studentCourseMap;
    private Map<Course, List<Student>> courseStudentMap;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
        studentCourseMap = new HashMap<>();
        courseStudentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        studentCourseMap.put(student, new ArrayList<>());
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
        courseStudentMap.put(course, new ArrayList<>());
    }

    public void enrollStudentInCourse(Student student, Course course) {
        studentCourseMap.get(student).add(course);
        courseStudentMap.get(course).add(student);
    }

    public List<Course> getCoursesByStudent(Student student) {
        return studentCourseMap.get(student);
    }

    public List<Student> getStudentsByCourse(Course course) {
        return courseStudentMap.get(course);
    }

    public Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) return s;
        }
        return null;
    }

    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equals(name)) return s;
        }
        return null;
    }

    public Course findCourseByName(String courseName) {
        for (Course c : courses) {
            if (c.getCourseName().equals(courseName)) return c;
        }
        return null;
    }

    public Teacher findTeacherById(int teacherId) {
        for (Teacher t : teachers) {
            if (t.getTeacherId() == teacherId) return t;
        }
        return null;
    }

    public Teacher findTeacherByName(String name) {
        for (Teacher t : teachers) {
            if (t.getName().equals(name)) return t;
        }
        return null;
    }
}
