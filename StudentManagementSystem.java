import java.util.Scanner;
import java.util.ArrayList;
class Student{
  int id;
  String name;
  String grade;
  Student(int id,String name,String grade){
    this.id = id;
    this.name = name;
    this.grade = grade;
  }
  @Override
  public String toString(){
    return "ID: "+id+" || Name: "+name+" || Grade: "+grade;
  }
}
public class StudentManagementSystem{
  static ArrayList<Student> studentList = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args){
    while(true){
      displayMenu();
      int choice = sc.nextInt();
      switch(choice){
        case 1:
          addStudent();
          break;
        case 2:
          viewStudent();
          break;
        case 3:
          searchStudent();
          break;
        case 4:
          updateStudent();
          break;
        case 5:
          deleteStudent();
          break;
        case 6:
          System.out.println("Exiting .....Goodbye...!");
          System.exit(0);
        default:
          System.out.println("Choose a valid option. Please try again."); 
    }
  }
}
  public static void displayMenu(){
    System.out.println("\n ---- Student Record Management System ----");
    System.out.println("1. Add Student");
    System.out.println("2. View Students");
    System.out.println("3. Search Students");
    System.out.println("4. Update Student");
    System.out.println("5. Delete Student");
    System.out.println("6. Exit");
    System.out.println("Enter your choice: ");
  }
  public static void addStudent(){
    System.out.println("Enter student ID: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter Student Name: ");
    String name = sc.nextLine();
    System.out.println("Enter Grade: ");
    String grade = sc.nextLine();
    studentList.add(new Student(id,name,grade));
    System.out.println("Student sucessfully added");
  }
  public static void viewStudent(){
    if(studentList.isEmpty()){
      System.out.println("No records found.");
    } else {
      System.out.println("\n ----Student List----");
      for(Student s : studentList){
        System.out.println(s);
      }
    }
  }
  public static void searchStudent(){
    System.out.println("Enter student ID to search: ");
    int id = sc.nextInt();
    for(Student s: studentList){
      if(s.id == id){
        System.out.println("Record found: "+s);
        return;
      }
    }
    System.out.println("Student not found");
  }
  public static void updateStudent(){
    System.out.println("Enter student ID to update: ");
    int id = sc.nextInt();
    sc.nextLine();
    for(Student s : studentList){
      if(s.id == id){
        System.out.println("Enter New Name: ");
        s.name = sc.nextLine();
        System.out.println("Enter New Grade: ");
        s.grade = sc.nextLine();
        System.out.println("Update successful.");
        return;
      }
    }
    System.out.println("Student not found.");
  }
  public static void deleteStudent(){
    System.out.println("Enter Student ID to delete: ");
    int id = sc.nextInt();
    for(int i=0 ; i<studentList.size() ; i++){
      if(studentList.get(i).id == id){
        studentList.remove(i);
        System.out.println("Record deleted.");
        return;
      }
    }
    System.out.println("Student not found");
  }
}
