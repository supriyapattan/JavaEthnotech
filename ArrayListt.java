import java.util.ArrayList;

public class ArrayListt{
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Anu");
        students.add("Rahul");
        students.add("Sneha");

        System.out.println("Student List:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + students.get(i));
        }
    }
}
