package org.example;

import java.util.*;

class QuickSort {
    // QuickSort method
    public static void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    private static int partition(List<Student> students, int low, int high) {
        Student pivot = students.get(high);
        double pivotMarks = pivot.getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getMarks() >= pivotMarks) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    // MergeSort method
    public static void mergeSort(List<Student> students, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(students, left, middle);
            mergeSort(students, middle + 1, right);
            merge(students, left, middle, right);
        }
    }

    private static void merge(List<Student> students, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Student> leftList = new ArrayList<>();
        List<Student> rightList = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftList.add(students.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(students.get(middle + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getMarks() >= rightList.get(j).getMarks()) {
                students.set(k, leftList.get(i));
                i++;
            } else {
                students.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            students.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            students.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
    // BubbleSort method
    public static void bubbleSort(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    // Main Method for Performance Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of students to test: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<Student> students = new ArrayList<>();
        for (int i = 1; i < numberOfStudents; i++) {
            String id = "ID" + i;
            String name = "Student " + i;
            double marks = random.nextDouble() * 10; // Random marks between 0 and 10
            students.add(new Student(i, name, marks));
        }

        // In list before sorting
        System.out.println("\nGenerated List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        List<Student> studentsForQuickSort = new ArrayList<>(students);
        List<Student> studentsForMergeSort = new ArrayList<>(students);
        List<Student> studentsForBubbleSort = new ArrayList<>(students);

        long quickSortTime = 0;
        long mergeSortTime = 0;
        long bubbleSortTime = 0;

        while (true) {
            System.out.println("\nChọn thuật toán để sắp xếp:");
            System.out.println("1. Sắp xếp bằng QuickSort");
            System.out.println("2. Sắp xếp bằng MergeSort");
            System.out.println("3. Sắp xếp bằng BubbleSort");
            System.out.println("4. So sánh thời gian sắp xếp của QuickSort, MergeSort và BubbleSort");
            System.out.println("5. Thoát");
            System.out.print("Chọn một trong các ý trên: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    long startTimeQuickSort = System.nanoTime();
                    quickSort(studentsForQuickSort, 0, studentsForQuickSort.size() - 1);
                    long endTimeQuickSort = System.nanoTime();
                    quickSortTime = endTimeQuickSort - startTimeQuickSort;
                    System.out.println("\nStudents sorted using QuickSort:");
                    for (Student student : studentsForQuickSort) {
                        System.out.println(student);
                    }
                    System.out.println("\nStudents sorted using QuickSort:");
                    System.out.println("QuickSort Time: " + quickSortTime + " nanoseconds");
                    break;

                case 2:
                    long startTimeMergeSort = System.nanoTime();
                    mergeSort(studentsForMergeSort, 0, studentsForMergeSort.size() - 1);
                    long endTimeMergeSort = System.nanoTime();
                    mergeSortTime = endTimeMergeSort - startTimeMergeSort;
                    System.out.println("\nStudents sorted using MergeSort:");
                    for (Student student : studentsForMergeSort) {
                        System.out.println(student);
                    }
                    System.out.println("\nStudents sorted using MergeSort:");
                    System.out.println("MergeSort Time: " + mergeSortTime + " nanoseconds");
                    break;
                case 3:
                    long startTimeBubbleSort = System.nanoTime();
                    bubbleSort(studentsForBubbleSort);
                    long endTimeBubbleSort = System.nanoTime();
                    bubbleSortTime = endTimeBubbleSort - startTimeBubbleSort;
                    System.out.println("\nStudents sorted using BubbleSort:");
                    for (Student student : studentsForBubbleSort) {
                        System.out.println(student);
                    }
                    System.out.println("\nStudents sorted using BubbleSort:");
                    System.out.println("BubbleSort Time: " + bubbleSortTime + " nanoseconds");
                    break;

                case 4:
                    if (quickSortTime == 0 || mergeSortTime == 0) {
                        System.out.println("\nPlease sort using both algorithms before comparing.");
                    } else {
                        System.out.println("\nQuickSort Time: " + quickSortTime + " nanoseconds");
                        System.out.println("MergeSort Time: " + mergeSortTime + " nanoseconds");
                        System.out.println("BubbleSort Time:" + bubbleSortTime + "nanoseconds");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
