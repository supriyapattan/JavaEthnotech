//even thread and odd thread 
import java.util.Scanner;

public class Multithreading {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        Thread t = new Thread(() -> {
            if (n % 2 == 0) {
                System.out.println(n + " is Even");
            } else {
                System.out.println(n + " is Odd");
            }
        });

        t.start();
        sc.close();
    }

}