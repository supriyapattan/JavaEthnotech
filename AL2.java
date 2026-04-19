//take variables from user for daily spending money
//calculate total spending amount
//if spend amount if more then 2000 then print "dont spend too much money limits on spending"
//if spend amount is less then 2000 then print "good job you are saving money"

import java.util.ArrayList;
import java.util.Scanner;

public class AL2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> dailySpending = new ArrayList<>();
        int totalSpending = 0;

        
        for(int i=1;i<=7;i++){
            System.out.println(" day "+i+" spending amount:");
            double spendingAmount = sc.nextDouble();
            dailySpending.add(spendingAmount);
            totalSpending += spendingAmount;
        }
        System.out.println("total spending amount is:"+totalSpending);
        
        if(totalSpending > 2000){
            System.out.println("dont spend too much money limits on spending");
        }
        else{
            System.out.println("good job you are saving money");
        }
    
        sc.close();
    }

    
}
