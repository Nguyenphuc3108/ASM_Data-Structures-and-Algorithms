package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            System.out.println("\nList:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Search Student by Name");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter mark: ");
                    double mark = scanner.nextDouble();
                    scanner.nextLine();

                    studentManagement.addStudent(new Student(id, name, mark));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new mark: ");
                    double newMark = scanner.nextDouble();
                    scanner.nextLine();

                    studentManagement.updateStudent(updateId, newName, newMark);
                    break;

                case 3:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    studentManagement.deleteStudent(deleteId);
                    break;

                case 4:
                    studentManagement.sortByMark();
                    break;

                case 5:
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = scanner.nextLine();
                    studentManagement.searchStudentByName(searchName);
                    break;

                case 6:
                    studentManagement.displayStudents();
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}