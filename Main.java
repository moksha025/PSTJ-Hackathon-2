import java.util.Scanner;

class Student {
    String studentName, courseName;
    int rollNumber, courseCredits;
    double marks;

    Student(String name, int roll, double marks, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        this.marks = marks;
        courseName = course;
        courseCredits = credits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {
        if (marks >= 85) return 20;
        if (marks >= 70) return 10;
        return 0;
    }

    double calculateFinalFee() {
        double fee = calculateFee();
        return fee - (fee * calculateScholarship() / 100);
    }

    void displayDetails() {
        double fee = calculateFee();
        double scholarship = fee * calculateScholarship() / 100;

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course: " + courseName);
        System.out.println("Credits: " + courseCredits);
        System.out.println("Eligibility: Eligible");
        System.out.println("Total Fee: Rs." + fee);
        System.out.println("Scholarship: Rs." + scholarship);
        System.out.println("Final Fee: Rs." + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Course Name: ");
        String course = sc.nextLine();

        System.out.print("Course Credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility())
            s.displayDetails();
        else
            System.out.println("Student is not eligible for registration.");

        sc.close();
    }
}