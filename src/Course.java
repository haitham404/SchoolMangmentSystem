public class Course {
    private String courseName;
    private Teacher teacher;

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
