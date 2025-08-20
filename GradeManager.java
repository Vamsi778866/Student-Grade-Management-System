import java.util.*;
 class Student {
    private String name;
    private String id;
    private double gpa;
    private Map<String, Double> grades;

    public Student(String name, String id){
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
        this.grades = new HashMap<>();
    }

    public void addGrade(String  course, double  grade){
        grades.put(course,  grade);
    }

    public double calculateGPA() {
        double sum=0;
        for (double grade : grades.values()) {
            sum +=grade;
        }
        gpa=sum/grades.size();
        return gpa;
    }

    public String getGradeReport() {
        StringBuilder report = new StringBuilder();
        report.append("Student Name: ").append  (name).append("\n");
        report.append("Student ID: ").append(id) .append("\n");
        report.append("GPA: ").append(gpa).append("\n");
        report.append("Grades:\n");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

public class GradeManager {
    private Map<String, Student> students;
    private Scanner scanner;

    public GradeManager() {
        this.students = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        students.put(id, new Student(name, id));
    }

    public void addGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); 


        Student student = students.get(studentId);
        if (student != null) {
            student.addGrade(course, grade);
        }
    }

    public void calculateGPA(){
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = students.get(studentId);
        if (student != null){
            System.out.println("GPA: " + student.calculateGPA());
        }

    }

    public void getGradeReport(){
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = students.get(studentId);
        if (student != null){
            System.out.println(student.getGradeReport());
        }
    }

    public void run(){
        while (true){
            System.out.println("1. Add student");
            System.out.println("2. Add grade");
            System.out.println("3. Calculate GPA");
            System.out.println("4. Get grade report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    calculateGPA();
                    break;
                case 4:
                    getGradeReport();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }



    }

    public static void main(String[] args){
        GradeManager manager = new GradeManager();
        manager.run();
    }
}