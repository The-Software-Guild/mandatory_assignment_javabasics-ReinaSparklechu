import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int maxNoRounds = 0;
        int userInput = 0;
        int computerInput = 0;
        int userRoundsWon = 0;
        int computerRoundsWon = 0;
        int roundsTied = 0;
        boolean quit = false;
        while(!quit){
            System.out.println("Minimum number of rounds: 1\nMaximum number of rounds: 10");
            System.out.printf("Please enter the maximum number rounds of rock paper scissors you would like to play: ");
            maxNoRounds = scanner.nextInt();
            if(maxNoRounds<1 || maxNoRounds>10){
                System.out.println("Invalid number of rounds. Ending game");
                break;
            }
            System.out.println();
            while(userRoundsWon <= (maxNoRounds-roundsTied)/2 && computerRoundsWon <= (maxNoRounds-roundsTied)/2 && userRoundsWon+computerRoundsWon+roundsTied<maxNoRounds){
                computerInput = random.nextInt(3)+1;
                System.out.println("1) Rock\n" + "2) Paper\n" + "3) Scissors");
                System.out.printf("Enter your choice: ");
                userInput = scanner.nextInt();
                if(userInput == computerInput){
                    roundsTied++;
                    switch (userInput){
                        case ROCK:
                            System.out.println("You both choose rock! Its a tie!");
                            break;
                        case PAPER:
                            System.out.println("You both choose paper! Its a tie!");
                            break;
                        case SCISSORS:
                            System.out.println("You both choose scissors! Its a tie!");
                            break;
                        default:
                            System.out.println("Something went horribly wrong\nStopping game.");
                            quit = true;

                    }
                }else if(userInput == ROCK){

                    if(computerInput == PAPER){
                        computerRoundsWon++;
                        System.out.println("You choose rock\nComputer choose paper\nYou lost");
                    }else{
                        userRoundsWon++;
                        System.out.println("You choose rock\nComputer choose scissors\nYou won!");
                    }
                }else if(userInput ==PAPER){
                    if(computerInput==ROCK){
                        System.out.println("You choose paper\nComputer choose rock\nYou won!");
                        userRoundsWon++;
                    }else{
                        System.out.println("You choose paper\nComputer choose scissors\nYou lost");
                        computerRoundsWon++;
                    }
                }else if(userInput == SCISSORS){
                    if (computerInput ==ROCK){
                        System.out.println("You choose scissors\nComputer choose rock\nYou lost");
                        computerRoundsWon++;
                    }else {
                        System.out.println("You choose scissors\nComputer choose paper\nYou lost");
                        userRoundsWon++;
                    }
                }else{
                    System.out.println("Invalid input. Ending game");
                    quit = true;
                    break;
                }
                System.out.println();

            }
            System.out.println("End of game");
            if(userRoundsWon == computerRoundsWon){
                System.out.println("Its a tie!");
            }else if(userRoundsWon> computerRoundsWon){
                System.out.println("You won!");
            }else{
                System.out.println("Computer won!");
            }
            System.out.printf("Total rounds played: %d\nRounds tied: %d\nRounds you won: %d\nRounds computer won: %d\n\n",
                    computerRoundsWon+userRoundsWon+roundsTied, roundsTied, userRoundsWon,computerRoundsWon);
            System.out.printf("Would you like to play again?\n1)Yes\n2)No\nYour input: ");
            userInput = scanner.nextInt();
            if (userInput == 1){
                System.out.println("You choose 1. Restarting game");
                userRoundsWon = 0;
                computerRoundsWon = 0;
                roundsTied = 0;
            }else if(userInput ==2){
                System.out.println("You choose 2. Stopping game.");
                quit = true;
            }else{
                System.out.println("Invalid option. Stopping game.");
                quit = true;
            }
        }
    }
}
