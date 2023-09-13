import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;
public class AIrouletteWheel{
    public static void main(String args[]){
        ArrayList<String> wheel = new ArrayList<String>();
        for(int i=0; i<18; i++){
            wheel.add("red");
            wheel.add("black");
        }
        wheel.add("green");
        wheel.add("green");
        Collections.shuffle(wheel);
        Scanner player = new Scanner(System.in);
        System.out.println("You are about to witness an AI play roulette, it will follow simple rules:");
        System.out.println("Start with a bet of $5");
        System.out.println("If it loses, double the bet");
        System.out.println("If it wins, reset to $5 and repeat");
        System.out.println("If it reaches the max bet and loses, it will reset to 5");
        System.out.println("Do you understand how to AI works? (press enter)");
        String idgafWhatTheyInput = player.nextLine();
        System.out.println("What color should the AI bet on (r/b)");
        char color = player.next().charAt(0);
        System.out.println("How many rounds should the AI play? (enter an Integer)");
        int rounds = player.nextInt();
        System.out.println("Should there be a max bet? (true/false)");
        boolean maxBet = player.nextBoolean();
        int maxBetValue = 0;
        if(maxBet){
            System.out.println("Enter the bet max");
            maxBetValue = player.nextInt();
        }
        
        int playerMoney = 0;
        int countRounds = 0;
        int currBet = 5;
        while(countRounds < rounds){
            Collections.shuffle(wheel);
            if(wheel.get(0).charAt(0) == color){
                playerMoney += currBet;
                currBet = 5;//reset to 5 after a win
            }
            else{
                playerMoney -= currBet;
                if(maxBet){//if there's a max bet
                    if(currBet*2 <= maxBetValue){
                        currBet *=2;
                    }
                    else{
                        currBet = 5;
                    }
                    
                }
                else{
                    currBet*=2;
                }
            }
            countRounds++;   
        }//end while loop
        System.out.println("Final balance is: " + playerMoney);
    }//end main method
}//end rouletteWheel