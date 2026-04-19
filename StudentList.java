

public class StudentList {

    public static void main(String[] args) {

        String[][] students = {
                {"Anu", "Rahul", "Sneha"},
                {"Kiran", "Meena", "Arjun"}
        };

        System.out.println("Student List:\n");

        
        for (int i = 0; i < students.length; i++) {
            System.out.println("Class " + (i + 1) + ":");

            for (int j = 0; j < students[i].length; j++) {
                System.out.println("  Student " + (j + 1) + ": " + students[i][j]);
            }

            System.out.println(); // empty line
        }
    }
}
