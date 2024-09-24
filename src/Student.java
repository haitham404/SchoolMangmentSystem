public class Student {
    private String name;
    private int studentId;
    private int age;
    private String grade;

    public Student(String name, int studentId, int age, String grade) {
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }
}
