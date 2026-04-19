package Storybased;
//light is control by switch 1 and switch 2
//switch1 is also connects fans
//switch2 is also connects machine
//check if switch 1 is on then switch 2 should be off and vice versa
//using truth table
//if switch1 is on then light and fan should be on and machine should be off
//if switch2 is on then light and machine should be on and fan should be off
import java.util.Scanner;

public class SwitchLight{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.println("Enter Switch 1 status (true = ON, false = OFF): ");
        boolean switch1 = sc.nextBoolean();

        System.out.println("Enter Switch 2 status (true = ON, false = OFF): ");
        boolean switch2 = sc.nextBoolean();

        System.out.println("\nSystem Output:");

        // XOR condition
        if (switch1 ^ switch2) {

            System.out.println("Light: ON and its Glowig!");

            if (switch1) {
                System.out.println("Fan: ON and its Rotating!");
               
                System.out.println("Machine: OFF");
            } else {
                System.out.println("Fan: OFF");
                
                System.out.println("Machine: ON and its Working!");
            }
        }

        else if (!switch1 && !switch2) {
            System.out.println("Light: OFF");
            System.out.println("Fan: OFF");
            System.out.println("Machine: OFF");
        }

        else {
            System.out.println("Invalid Condition! Both switches cannot be ON.");
        }

        sc.close();
    }
}
