import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int attendanceCount = 0;

        System.out.println("Enter attendance for 7 days (1 = Present, 0 = Absent)");

        for (int day = 1; day <= 7; day++) {
            System.out.print("Day " + day + ": ");
            int input = sc.nextInt();

            if (input == 1) {
                attendanceCount++;
            } 
            else if (input != 0) {
                System.out.println("Invalid input! Please enter only 0 or 1.");
                day--; 
            }
        }

        System.out.println("\nTotal Present Days: " + attendanceCount);

        if (attendanceCount < 4) {
            System.out.println("Status: Not Allowed to Write Exam");
        } else {
            System.out.println("Status: Allowed to Write Exam");
        }

        sc.close();
    }
}
