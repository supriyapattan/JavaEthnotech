public class ChessBoard {
    public static void main(String args[]){
        int n=8;
        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
               
                    
                if((i+j)%2==0){
                    System.out.print("W ");
                }
                else{
                    System.out.print("B ");
                }
            }
            System.out.println(); 
        }
    }
    
}
