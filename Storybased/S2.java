package Storybased;
//use metheod calling
//call the start and stop
//for light class print glow after the turn off it prints the light is already off its current state is off
//for fan class print rotate
//for ac class print cool
import java.util.Scanner;

    public class S2 {
        abstract class Device {
            abstract void start();
            abstract void stop();
            public Device() {
            }
        }
        class Light extends Device{
            private boolean isOn = false;

            public void start() {
                if (isOn) {
                    System.out.println("Light is already on!");
                } else {
                    isOn = true;
                    System.out.println("Light is glowing!");
                }
            }

            public void stop() {
                if (!isOn) {
                    System.out.println("Light is already off!");
                } else {
                    isOn = false;
                    System.out.println("Current state of Light is off.");
                }
            }
        }
        class Fan extends Device{
            private boolean isOn = false;

            public void start() {
                if (isOn) {
                    System.out.println("Fan is already on!");
                } else {
                    isOn = true;
                    System.out.println("Fan is rotating!");
                }
            }

            public void stop() {
                if (!isOn) {
                    System.out.println("Fan is already off!");
                } else {
                    isOn = false;
                    System.out.println("Current state of Fan is off.");
                }
            }
        }
        class Ac extends Device{
            private boolean isOn = false;
            public void start(){
                if (isOn){
                    System.out.println("Ac is already on!");
                } else {
                    isOn = true;
                    System.out.println("Ac is cooling!");
                }
            }
            public void stop(){
                if (!isOn){
                    System.out.println("Ac is already off!");
                } else {
                    isOn = false;
                    System.out.println("Current state of Ac is off.");
                }
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Device Control System!");
        System.out.println("\nChoose Device:");
        System.out.println("1. Light");
        System.out.println("2. Fan");
        System.out.println("3. AC");
        S2 s = new S2();
        Light l=s.new Light();
        Fan f=s.new Fan();
        Ac a=s.new Ac();
           
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You selected Light.");
                l.start();
                l.stop();
                break;
            case 2:
                System.out.println("You selected Fan.");
                f.start();
                f.stop();
                break;
            case 3:
                System.out.println("You selected AC.");
                a.start();
                a.stop();

                break;
        }
        
        sc.close();
    }
    
}

