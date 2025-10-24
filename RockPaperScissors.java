import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        // Score tracking variables
        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;
        
        System.out.println("==============================");
        System.out.println("  ROCK-PAPER-SCISSORS GAME");
        System.out.println("==============================\n");
        
        boolean playAgain = true;
        
        // Main game loop
        while (playAgain) {
            String playerChoice = "";
            boolean validInput = false;
            
            // Input validation loop
            while (!validInput) {
                System.out.print("Enter your choice (rock, paper, or scissors): ");
                playerChoice = sc.nextLine().toLowerCase().trim();
                
                if (playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors")) {
                    validInput = true;
                } else {
                    System.out.println("❌ Invalid choice! Please enter 'rock', 'paper', or 'scissors'.\n");
                }
            }
            
            // Computer randomly selects a choice
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[rand.nextInt(3)];
            
            // Display choices
            System.out.println("\nYou chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);
            System.out.println();
            
            // Determine winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("🤝 It's a tie!");
                ties++;
            } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win!");
                playerWins++;
            } else {
                System.out.println("💻 Computer wins!");
                computerWins++;
            }
            
            // Display current score
            System.out.println("\n--- Current Score ---");
            System.out.println("Player: " + playerWins + " | Computer: " + computerWins + " | Ties: " + ties);
            System.out.println();
            
            // Ask if player wants to play again
            System.out.print("Play again? (yes/no): ");
            String response = sc.nextLine().toLowerCase().trim();
            
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
            
            System.out.println();
        }
        
        // Display final score
        System.out.println("==============================");
        System.out.println("      FINAL SCORE");
        System.out.println("==============================");
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
        System.out.println("\nTotal Rounds Played: " + (playerWins + computerWins + ties));
        System.out.println("\nThanks for playing! 👋");
        
        sc.close();
    }
}