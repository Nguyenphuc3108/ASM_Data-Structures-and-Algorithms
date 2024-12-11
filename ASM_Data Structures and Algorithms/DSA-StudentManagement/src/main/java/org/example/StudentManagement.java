package org.example;
import java.util.Comparator;
import java.util.Stack;

public class StudentManagement {
    StudentStack studentStack;
    //private Stack<Student> students;
    public  StudentManagement(){
        studentStack = new StudentStack();
    }
    //Add student to list
    public void addStudent(Student student)
    {
        studentStack.push(student);
    }
    // Update an existing student's details
    public void updateStudent(int id, String newName, double newMarks) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newMarks));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    // Delete a student by ID
    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack<>();


        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }
        // Restore the original stack without the deleted student
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
    }
    //Sort students by Mark
    public void sortByMark() {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No students to sort.");
            return;
        }

        StudentStack sortedStack = new StudentStack();
        while (!studentStack.isEmpty()) {
            Student temp = studentStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek().getMarks() > temp.getMarks()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }
        displayStudents();
        System.out.println("Students sorted by marks.");
    }
    //Search Student by Name
    public void searchStudentByName(String name) {
        Node current = studentStack.top;
        boolean found = false;

        while (current != null) {
            if (current.student.getName().equalsIgnoreCase(name)) {
                System.out.println("Found student: " + current.student);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
    public void displayStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        studentStack.displayStudents();


    }


}



