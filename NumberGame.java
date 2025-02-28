import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int chances=8;
        int finals=0;
        boolean playAgain=true;
        System.out.println("Welcome Buddy");
        System.out.println("Hey you have about "+chances+"to win the match");
        while(playAgain){
            int rand=getrandN(1,100);
            boolean guess=false;
            for(int i=0;i<chances;i++){
                System.out.println("chances"+(i+1)+" : enter your guess");
                int user=sc.nextInt();
                if(user==rand){
                    guess=true;
                    finals+=1;
                    System.out.println("YOU WON!!");
                    break;
                }
                else if(user>rand){
                    System.out.println("TOO HIGH");
                }  else{
                    System.out.println("TOO LOW");
                }
            }
            if(guess==false){
                System.out.println("SORRY! you lost the game. The number is "+rand);
            }
            System.out.println("Do you want to play again(y/n)");
            String pA=sc.next();
            playAgain=pA.equalsIgnoreCase("y");
        }
        System.out.println("That's it buddy, Hope you enjoyed it");
        System.out.println("Here is your score: "+finals);
        
    }
    public static int getrandN(int min, int max){
        return(int)(Math.random()*(max-min+1)+min);

    }
    
    
}