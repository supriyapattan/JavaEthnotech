//Banking System
//when user put negative amount
//balance is insufficient
//if nestwork fails 
//final msg after doning all transactions
import java.util.Scanner;
public class Exception {
    public static void main(String main[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        double balance = 1000.0;

        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative.");
            }
            if (amount > balance) {
                throw new IllegalStateException("Insufficient balance.");
            }
            
            if (Math.random() < 0.1) {
                throw new RuntimeException("Network failure. Please try again.");
            }
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our banking system.");
        }
        
    }
    
}
