import java.util.Scanner;

class ScannerDemo {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter College name:");
        String colname = s.nextLine();

        System.out.println("Enter student name:");
        String name = s.next();

        System.out.println("Enter roll number:");
        int rollno = s.nextInt();

        System.out.println("Enter student score:");
        float score = s.nextFloat();

        System.out.println("Enter semester:");
        byte sem = s.nextByte();

        System.out.println("Enter gender:");
        char gender = s.next().charAt(0);

        System.out.println("\n----- Student Details -----");
        System.out.println("College Name = " + colname);
        System.out.println("Student Name = " + name);
        System.out.println("Roll No = " + rollno);
        System.out.println("Semester = " + sem);
        System.out.println("Gender = " + gender);
        System.out.printf("Score = %.2f", score);

        s.close();
    }
}