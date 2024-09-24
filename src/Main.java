import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static School school = new School();

    public static void main(String[] args) {
        boolean i = true;
        while (i) {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. View Student's Enrolled Courses");
            System.out.println("6. View Students in a Specific Course");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    enrollStudent();
                    break;
                case 5:
                    viewStudentCourses();
                    break;
                case 6:
                    viewStudentsInCourse();
                    break;
                case 7:
                    i = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        String grade = scanner.next();

        if (school.findStudentById(id) == null) {
            school.addStudent(new Student(name, id, age, grade));
            System.out.println("Student added.");
        }
        else System.out.println("Student with this ID already exists.");

    }

    private static void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.next();
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter teacher subject: ");
        String subject = scanner.next();
        System.out.print("Enter teacher salary: ");
        double salary = scanner.nextDouble();

        if (school.findTeacherById(id) == null) {
            school.addTeacher(new Teacher(name, id, subject, salary));
            System.out.println("Teacher added.");
        }
         else System.out.println("Teacher with this ID already exists.");

    }

    private static void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        System.out.print("Enter course teacher: ");
        String teacherName = scanner.next();

        Teacher teacher = school.findTeacherByName(teacherName);
        if (teacher != null) {
            school.addCourse(new Course(courseName, teacher));
            System.out.println("Course added.");
        }
        else System.out.println("There is no teacher with that name.");

    }

    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course name: ");
        String courseName = scanner.next();

        Student student = school.findStudentById(studentId);
        Course course = school.findCourseByName(courseName);

        if (student != null && course != null) {
            school.enrollStudentInCourse(student, course);
            System.out.println("Student enrolled.");
        }
        else {
            if (student == null && course == null) System.out.println("Both student and course not found.");
             else if (student == null) System.out.println("Student not found.");
             else System.out.println("Course not found.");
        }
    }

    private static void viewStudentCourses() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        Student student = school.findStudentByName(name);

        if (student != null) {
            System.out.println("Courses enrolled by " + student.getName() + ":");
            for (Course course : school.getCoursesByStudent(student)) System.out.println("- " + course.getCourseName());
        }
        else  System.out.println("Student not found.");
    }

    private static void viewStudentsInCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        Course course = school.findCourseByName(courseName);

        if (course != null) {
            System.out.println("Students enrolled in " + course.getCourseName() + ":");
            for (Student student : school.getStudentsByCourse(course)) System.out.println("- " + student.getName());
        }
        else System.out.println("Course not found.");
    }
}
