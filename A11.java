//ArrayList for differenciating in .add[1] and  .add["java"]
import java.util.ArrayList;

public class A11 {
    public static void main(String args[]){
        ArrayList<Object> numbers = new ArrayList<>();
        numbers.add(1);
        System.out.println(numbers.get(0));
        numbers.add("ABC");
        System.out.println(numbers.get(1));

    }
    
}
