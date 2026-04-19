package Storybased;
//a company bilding a new game user can use to one membership card to play game .there are 
// 3 game racing ,shooting and VR advanture game 
// after enter player buy and pay membershipcard and
//  he choose any game 
//racing 50 credit,shooting 75 credit and advanture 100 credit or Each play have different credits
//All game want to comman way to start and stop any game
//wallet balance must  be protected form direct modification 
//run different game using same reference
import java.util.Scanner;

// Interface
interface GameControl {
    void start();
    void stop();
}

// Encapsulation
class Wallet {
    private int balance;

    public Wallet(int amount) {
        balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void deductCredits(int credits) {
        if (credits <= balance) {
            balance -= credits;
            System.out.println("Credits deducted: " + credits);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Abstraction
abstract class Game implements GameControl {
    protected int requiredCredits;
    protected Wallet wallet;

    public Game(Wallet wallet, int requiredCredits) {
        this.wallet = wallet;
        this.requiredCredits = requiredCredits;
    }

    public void play() {

        if (wallet.getBalance() < requiredCredits) {
            System.out.println("Not enough credits to play.");
            return;
        }

        wallet.deductCredits(requiredCredits);

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to start the game? (yes/no)");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {

            start();

            try {
                System.out.println("Game will run for 2 hours...");
                
                // Real 2 hours (uncomment below line)
                // Thread.sleep(7200000);

                // Demo version (5 seconds for testing)
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("Game interrupted.");
            }

            stop();
            System.out.println("Game automatically stopped after time limit.");

        } else {
            System.out.println("Game not started.");
        }
    }
}

// Inheritance
class RacingGame extends Game {
    public RacingGame(Wallet wallet) {
        super(wallet, 50);
    }

    public void start() {
        System.out.println("🚗 Racing Game Started!");
    }

    public void stop() {
        System.out.println("🏁 Racing Game Stopped!");
    }
}

class ShootingGame extends Game {
    public ShootingGame(Wallet wallet) {
        super(wallet, 70);
    }

    public void start() {
        System.out.println("🔫 Shooting Game Started!");
    }

    public void stop() {
        System.out.println("🎯 Shooting Game Stopped!");
    }
}

class VRAdventureGame extends Game {
    public VRAdventureGame(Wallet wallet) {
        super(wallet, 100);
    }

    public void start() {
        System.out.println("🥽 VR Adventure Game Started!");
    }

    public void stop() {
        System.out.println("🌟 VR Adventure Game Stopped!");
    }
}

// Main Class
public class GameSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount to buy Membership Card:");
        int amount = sc.nextInt();

        Wallet wallet = new Wallet(amount);

        System.out.println("\nChoose Game:");
        System.out.println("1. Racing (50 credits)");
        System.out.println("2. Shooting (70 credits)");
        System.out.println("3. VR Adventure (100 credits)");

        int choice = sc.nextInt();

        Game game = null;

        switch (choice) {
            case 1:
                game = new RacingGame(wallet);
                break;
            case 2:
                game = new ShootingGame(wallet);
                break;
            case 3:
                game = new VRAdventureGame(wallet);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        game.play();  // Polymorphism

        System.out.println("Remaining Balance: " + wallet.getBalance());

        sc.close();
    }
}

