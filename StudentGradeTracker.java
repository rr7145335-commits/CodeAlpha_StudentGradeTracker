import java.util.Scanner;

public class StudentGradeTracker {

    static String[] names = new String[100];
    static double[] grades = new double[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Show Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    showReport();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter grade (0-100): ");
        double grade = sc.nextDouble();
        sc.nextLine();

        names[count] = name;
        grades[count] = grade;
        count++;

        System.out.println("Student added successfully!");
    }

    static void showAllStudents() {
        if (count == 0) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + grades[i]);
        }
    }

    static void showReport() {
        if (count == 0) {
            System.out.println("No student data available.");
            return;
        }

        double total = 0;
        double highest = grades[0];
        double lowest = grades[0];
        String topStudent = names[0];
        String lowStudent = names[0];

        for (int i = 0; i < count; i++) {
            total += grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
                topStudent = names[i];
            }

            if (grades[i] < lowest) {
                lowest = grades[i];
                lowStudent = names[i];
            }
        }

        double average = total / count;

        System.out.println("\n===== SUMMARY REPORT =====");
        System.out.println("Total Students : " + count);
        System.out.println("Average Grade  : " + average);
        System.out.println("Highest Grade  : " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade   : " + lowest + " (" + lowStudent + ")");
        System.out.println("==========================");
    }
}
