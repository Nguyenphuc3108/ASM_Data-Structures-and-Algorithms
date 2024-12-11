package org.example;

class StudentStack {
    public Node top; // Top of the stack
    private int size; // To keep track of the number of elements

    // Constructor
    public StudentStack() {
        top = null; // Stack is initially empty
        size = 0;   // Initial size is 0
    }

    // Push a student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top; // Point new node to the previous top
        top = newNode;      // Update top to be the new node
        size++;

    }

    // Pop a student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        }
        Student poppedStudent = top.student; // Get the student from the top node
        top = top.next;                     // Move top to the next node
        size--;
        return poppedStudent;
    }

    // Peek at the top student
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return top.student; // Return the student at the top node
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null; // Stack is empty if top is null
    }

    // Get the size of the stack
    public int size() {
        return size; // Return current size of the stack
    }

    // Display all students in the stack
    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }

        System.out.println("Students in Stack:");
        Node current = top;  // Start from the top node
        while (current != null) {
            System.out.println(current.student);
            current = current.next; // Move to the next node
        }
    }

    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();
        //Adding students to the stack
        studentStack.push(new Student(1, "Hieu", 7.5));
        studentStack.push(new Student(2, "Hoang", 8));

        // Displaying all students in the stack
        studentStack.displayStudents();

        // Peeking at the top student
        System.out.println("Top student: " + studentStack.peek());

        // Popping a student from the stack
        System.out.println("Popped: " + studentStack.pop());

        // Displaying remaining students after pop
        studentStack.displayStudents();

        // Adding more students to test dynamic resizing
        studentStack.push(new Student(3, "Giang", 7));
        studentStack.push(new Student(4, "My", 6));

        // Displaying all students after adding more
        studentStack.displayStudents();

        // Popping all students to demonstrate underflow condition
        studentStack.pop();
        studentStack.pop();
        studentStack.pop();

        // Attempting to display students after popping all
        studentStack.displayStudents();

        // Checking if the stack is empty
        System.out.println("Is stack empty? " + studentStack.isEmpty());
    }
}