package org.example;

import java.util.*;

public class StudentManagementErrorHandling {

    private final List<Student> students = new ArrayList<>();

    // Add Student Method
    public void addStudent(int id, String name, double marks) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Invalid Student Name.");
            return;
        }
        if (students.stream().anyMatch(s -> s.getId() == id)) {
            System.out.println("Error: Duplicate Student ID.");
            return;
        }
        if (marks < 0 || marks > 10) {
            System.out.println("Error: Marks must be between 0 and 10.");
            return;
        }
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    // Edit Student Method
    public void editStudent(int id, String newName, double newMarks) {
        Optional<Student> studentOpt = students.stream().filter(s -> s.getId() == id).findFirst();
        if (studentOpt.isEmpty()) {
            System.out.println("Error: Student ID not found.");
            return;
        }
        if (newName == null || newName.isEmpty()) {
            System.out.println("Error: Invalid Student Name.");
            return;
        }
        if (newMarks < 0 || newMarks > 10) {
            System.out.println("Error: Marks must be between 0 and 10.");
            return;
        }
        Student student = studentOpt.get();
        student.setName(newName);
        student.setMarks(newMarks);
        System.out.println("Student updated successfully.");
    }

    // Delete Student Method
    public void deleteStudent(int id) {
        if (!students.removeIf(student -> student.getId() == id)) {
            System.out.println("Error: Student ID not found.");
        } else {
            System.out.println("Student deleted successfully.");
        }
    }

    // Search Student Method
    public void searchStudent(int id) {
        Optional<Student> studentOpt = students.stream().filter(s -> s.getId() == id).findFirst();
        if (studentOpt.isPresent()) {
            System.out.println(studentOpt.get());
        } else {
            System.out.println("Error: Student ID not found.");
        }
    }

    // Main Method
    public static void main(String[] args) {
        StudentManagementErrorHandling sm = new StudentManagementErrorHandling();

        // Test Cases
        sm.addStudent(101, "Hoang", 8.5);   // Valid Input
        sm.addStudent(102, "", 11);           // Error: Invalid Student Name
        sm.addStudent(103, "Hieu", -5);      // Error: Marks must be between 0 and 10
        sm.searchStudent(104);                // Error: Student ID not found
        sm.deleteStudent(104);                // Error: Student ID not found
        sm.editStudent(101, "Son", 9); // Valid Update
        sm.searchStudent(101);                // Should display updated details
    }
}
