import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;
public class rouletteWheel{
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
        System.out.println("Would you like to play roulette? (press enter)");
        String idgafWhatTheyInput = player.nextLine();
        System.out.println("Here's what the Wheel consists of (press enter)");
        idgafWhatTheyInput = player.nextLine();
        System.out.println(wheel);
        System.out.println();
        System.out.println("Lets start with 8 example rolls (press enter)");
        idgafWhatTheyInput = player.nextLine();
        for(int i=0; i<8; i++){
            Collections.shuffle(wheel);
            System.out.println(wheel.get(0));
        }
        System.out.println();
        System.out.println("(press enter)");
        idgafWhatTheyInput = player.nextLine();
        System.out.println("Lets get started");
        System.out.println("Minimum bet: $5");
        System.out.println("Maximum bet $100");
        System.out.println("Integer values only");
        System.out.println("To bet, press either 'r' for red, or 'b' for black, followed by a space then your bet amount");
        System.out.println("For example, 'r 50' would place $50 on red");
        System.out.println("Do you understand the rules? (press enter)");
        idgafWhatTheyInput = player.nextLine();
        int playerMoney = 0;
        while(true){
            System.out.println("Current balance $ " + playerMoney);
            System.out.println();
            System.out.println("Place your bet");
            boolean makeSureUserInputIsValid = false;
            char color = 'x';
            int wageInt = 0;//initialized out here for scope reasons
            while(!makeSureUserInputIsValid){
                try{
                    String bet = player.nextLine();
                    color = bet.charAt(0);
                    if(bet.length() == 3){//bet is 5-9
                        char wage = bet.charAt(2);
                        wageInt = Character.getNumericValue(wage);
                    }
                    else if(bet.length() == 4){
                        char wage = bet.charAt(2);//tens value
                        wageInt = 10*Character.getNumericValue(wage);
                        wage = bet.charAt(3);//ones value
                        wageInt += Character.getNumericValue(wage);
                    }
                    else if(bet.length() == 5){              
                        char wage = bet.charAt(2);//hundreds value
                        wageInt = 100*Character.getNumericValue(wage);
                        wage = bet.charAt(3);//tens value
                        wageInt += 10*Character.getNumericValue(wage); 
                        wage = bet.charAt(4);//ones value
                        wageInt += Character.getNumericValue(wage);
                    }
                    else{
                        char wage = bet.charAt(-1);//just throwing an exception
                    }
                    if(wageInt >= 5 && wageInt <= 100){
                        if(color == 'r' || color == 'b'){
                            makeSureUserInputIsValid = true;
                        }
                        else{
                            System.out.println("Invalid input, please try again");
                        }
                    }
                    else{
                            System.out.println("Invalid input, please try again");
                        }
                        }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input, please try again");
                   // player.nextLine(); // Clear the input buffer to prevent infinite loop
                }
                catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid input, please try again");
                    //player.nextLine(); // Clear the input buffer to prevent infinite loop   
                }
            }//end makeSureUserInputIsValid
            Collections.shuffle(wheel);
            System.out.println("The wheel spins: " + wheel.get(0));
            char colorOnWheel = wheel.get(0).charAt(0);
            if(color == colorOnWheel){
                playerMoney += wageInt;
                System.out.println("You win!!!");
            }
            else{
                playerMoney -= wageInt;
                System.out.println("You lose :(");
            }
            System.out.println("Would you like to play again? (press enter)");
            idgafWhatTheyInput = player.nextLine();
        }//end while true
    }//end main method
}//end rouletteWheel