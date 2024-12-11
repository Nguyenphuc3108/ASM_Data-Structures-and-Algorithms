package org.example;

class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor to initialize a student with id, name, and marks
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Default constructor (if needed)
    public Student() {}

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Get the ranking based on marks
    public String getRanking() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    // Getter and Setter for id, name, and marks
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    // toString method to display student details
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", Ranking='" + getRanking() + '\'' +
                '}';
    }
}
