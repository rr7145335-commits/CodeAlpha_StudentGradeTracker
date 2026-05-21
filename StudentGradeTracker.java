import java.util.Scanner;

public class StudentGradeTracker {

    // storing student names and grades
    static String[] names = new String[100];
    static double[] grades = new double[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("   Student Grade Tracker");
        System.out.println("==============================");

        int choice = 0;

        while (choice != 4) {

            System.out.println("\nMenu:");
            System.out.println("1 - Add a student");
            System.out.println("2 - Show all students");
            System.out.println("3 - Show report");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addStudent(sc);
            }
            else if (choice == 2) {
                showAllStudents();
            }
            else if (choice == 3) {
                showReport();
            }
            else if (choice == 4) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Wrong choice, please try again.");
            }
        }

        sc.close();
    }

    // this function adds a new student
    static void addStudent(Scanner sc) {

        System.out.print("Student name: ");
        String name = sc.nextLine();

        System.out.print("Their grade (0-100): ");
        double grade = sc.nextDouble();
        sc.nextLine();

        names[count] = name;
        grades[count] = grade;
        count++;

        System.out.println(name + " added successfully!");
    }

    // this function shows all students
    static void showAllStudents() {

        if (count == 0) {
            System.out.println("No students yet.");
            return;
        }

        System.out.println("\nAll Students:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + grades[i]);
        }
    }

    // this function shows the final report
    static void showReport() {

        if (count == 0) {
            System.out.println("No students to report.");
            return;
        }

        double total = 0;
        double highest = grades[0];
        double lowest = grades[0];
        String topStudent = names[0];
        String lowestStudent = names[0];

        for (int i = 0; i < count; i++) {
            total = total + grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
                topStudent = names[i];
            }

            if (grades[i] < lowest) {
                lowest = grades[i];
                lowestStudent = names[i];
            }
        }

        double average = total / count;

        System.out.println("\n===== Final Report =====");
        System.out.println("Number of students : " + count);
        System.out.println("Average grade      : " + average);
        System.out.println("Highest grade      : " + highest + " (" + topStudent + ")");
        System.out.println("Lowest grade       : " + lowest + " (" + lowestStudent + ")");
        System.out.println("========================");
    }
}