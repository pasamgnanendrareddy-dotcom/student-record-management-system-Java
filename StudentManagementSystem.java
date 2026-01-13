import java.util.Scanner;
import java.util.ArrayList;
class Student {
    private int id;
    private String name;
    private String grade;
    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public int getId() { 
      return id;
    }
    public void setName(String name) { 
      this.name = name;
    }
    public void setGrade(String grade) { 
      this.grade = grade; 
    }
    @Override
    public String toString() {
      return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}
public class StudentManagementSystem {
    private static ArrayList<Student> sl = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting.... Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("\n--- Student Record Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void addStudent() {
      System.out.print("Enter Student ID: ");
      int id = sc.nextInt();
      sc.nextLine();
      if (findStudentById(id) != null) {
          System.out.println("Error: Student ID " + id + " already exists.");
          return;
      }
      System.out.print("Enter Name: ");
      String name = sc.nextLine();
      if (name.isBlank()) {
          System.out.println("Name cannot be empty.");
          return;
      }
      System.out.print("Enter Grade: ");
      String grade = sc.nextLine();
      sl.add(new Student(id, name, grade));
      System.out.println("Student added successfully!");
  }
    private static void viewStudents() {
        if (sl.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("\n--- Current Student Records ---");
            sl.forEach(System.out::println);
        }
    }
    private static void searchStudent() {
        System.out.print("Search ID: ");
        int id = sc.nextInt();
        Student s = findStudentById(id);
        System.out.println(s != null ? "Found: " + s : "Student not found.");
    }
    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student s = findStudentById(id);
        if (s != null) {
            System.out.print("New Name: ");
            s.setName(sc.nextLine());
            System.out.print("New Grade: ");
            s.setGrade(sc.nextLine());
            System.out.println("Update successful.");
        } else {
            System.out.println("Not found.");
        }
    }
    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Student s = findStudentById(id);
        if (s != null) {
            sl.remove(s);
            System.out.println("Record deleted.");
        } else {
            System.out.println("Not found.");
        }
    }
    private static Student findStudentById(int id) {
        for (Student s : sl) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
