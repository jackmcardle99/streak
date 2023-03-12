import java.util.Scanner;

public class Menu {

    /*
    AUTHOR : Jack McArdle
             B00733578
             mcardle-j9@ulster.ac.uk

    This class is the main class of the application, and acts as a menu for accessing different parts of the game. There
    is some minor game logic here related to the scoreboard feature.
     */

    private static final Scoreboard<Player> scoreTable = new Scoreboard<>(); // PQueue data structure to hold scores

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        Streak streak = new Streak();
        Battaile ok = new Battaile();
            while(true){
                Scanner scan = new Scanner(System.in);
                System.out.println("""
                    <><><><><><><><><><><>< STREAK ><><><><><><><><><><><><><><><>
                    (1) Single player
                    (2) Two player
                    (3) Rules
                    (4) Score table
                    (5) Exit
                    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
                    """);
                String userInput = scan.nextLine();
                switch (userInput) {
                    case "1" -> ok.setUp();  //streak.play(true); // pass true for singleplayer, false for two player
                    case "2" -> streak.play(false);
                    case "3" -> rules();
                    case "4" -> printScoreboard();
                    case "5" -> {
                        System.out.println("Thanks for playing!");
                        System.exit(0);
                    }
                }
            }
    }

    private static void rules(){
        System.out.println("""
                Streak is a card game for up to 2 players in which players aim to score the highest
                streak possible from the cards dealt into their hand. The player can exchange cards as many times
                as the size of the hand. E.g. if a player has a hand of 5 cards, they can make 5 swaps.
                
                The aim is to create the highest streak possible. If streaked cards are the same colour, the streak is
                awarded a bonus of 1 point. If the streak is comprised of cards of the same suit, then a bonus is awarded
                of 2 points. If two consecutive cards are of the same value, the streak is broken.
                
                In a two player game, each player plays their 3 hands, and the winner is the player with the highest
                cumulative score over their 3 rounds.
                
                The scoreboard holds the 5 highest single hands.
                """);
    }

    public static void printScoreboard(){
        if(scoreTable.isEmpty()){
            System.out.println("\nNo high scores yet!\n");
            menu();
        }
        int size = scoreTable.getNumberOfEntries();
        Player[] temp = new Player[size];
        String[][] table = new String[size][2]; // Table with two columns, holding player name in one, and player score in other
        for(int i = 0; i < size; i++){
            if(scoreTable.getFront()==null) break;
            table[i] = new String[]{scoreTable.getFront().getPlayerName(), String.valueOf(scoreTable.getFront().getPlayerScore())};
            temp[i] = scoreTable.dequeue();
        }
        for(int i = 0; i < size; i++){
            scoreTable.enqueue(temp[i]); // after high-scores displayed, they must be put back into the queue data structure
        }
        System.out.println("\nPLAYER                        SCORE");
        System.out.println("-----------------------------------");
        for (final Object[] row : table) {
            System.out.format("%-30s%-30s%n", row);
        }
        System.out.println("\n");
    }

    public void addToScoreboard(Player playerToAdd){ // this method is called when adding a player to the scoreboard
        scoreTable.enqueue(playerToAdd);             // at the end of every game.
    }
}
