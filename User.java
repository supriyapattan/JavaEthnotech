//take input from user like numbers of rows and colums and print the matric
import java.util.Scanner;
public class User {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of rows:");
        int rows=sc.nextInt();
        System.out.println("Enter no of columns:");
        int columns=sc.nextInt();
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                if((i+j)%2==0){
                    System.out.print("W ");
                }
                else{
                    System.out.print("B ");
                }
                
            }
            System.out.println(); 
        }
        sc.close();
    }

    
}
