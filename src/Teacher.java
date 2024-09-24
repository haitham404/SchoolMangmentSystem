public class Teacher {
    private String name;
    private int teacherId;
    private String subject;
    private double salary;

    public Teacher(String name, int teacherId, String subject, double salary) {
        this.name = name;
        this.teacherId = teacherId;
        this.subject = subject;
        this.salary = salary;
    }

    // Getters and Setters for each field
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
