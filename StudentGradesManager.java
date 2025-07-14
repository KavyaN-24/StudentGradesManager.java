import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradesManager {

    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grades Manager ===");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Enter grade for " + name + " (0 - 100): ");
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        // Calculations
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        Student topStudent = null;
        Student lowStudent = null;

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s;
            }
        }

        double average = total / students.size();

        // Summary Report
        System.out.println("\n=== Summary Report ===");
        System.out.printf("%-20s %-10s\n", "Student Name", "Grade");
        for (Student s : students) {
            System.out.printf("%-20s %-10.2f\n", s.name, s.grade);
        }

        System.out.println("\nTotal Students: " + students.size());
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + topStudent.name + " (" + topStudent.grade + ")");
        System.out.println("Lowest Grade : " + lowStudent.name + " (" + lowStudent.grade + ")");
    }
}
