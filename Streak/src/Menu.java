import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    /*
    AUTHOR : Jack McArdle
             B00733578
             mcardle-j9@ulster.ac.uk

    This class is the main class of the application, and acts as a menu for accessing different parts of the game. No
    game logic is defined here.
     */

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        Streak streak = new Streak();
            while(true){
                Scanner scan = new Scanner(System.in);
                System.out.println("""
                    Welcome to Streak!
                    Please choose from the options available
                    (1) Single player
                    (2) Two player
                    (3) Rules
                    (4) Score table
                    (5) Exit""");
                String userInput = scan.nextLine();
                switch (userInput) {
                    case "1" -> streak.play(true); // pass true for singleplayer, false for two player
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
        System.out.println("Rules will be here.");
    }

    private static void printScoreboard(){
        /*
         possibly an array, that holds 5 players, each with the top score, if someone gets a high score, then
         it checks the array to see if replaces someone in the array. Then that player gets assigned as the index of the
         table below in order

         */
        Player playerTest = new Player("jack",5);
        Player playerTest2 = new Player("lee",4);
        String[][] table = new String[6][2];
        table[0] = new String[]{"PLAYER ","SCORE "};
        table[1] = new String[]{playerTest.getPlayerName(), String.valueOf(playerTest.getPlayerScore())};
        table[2] = new String[]{playerTest2.getPlayerName(), String.valueOf(playerTest2.getPlayerScore())};
        for (final Object[] row : table) {
            System.out.format("%-30s%-30s%n", row);

        }
    }

    public Player createPlayer (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name > ");
        return new Player(scan.nextLine(), 0);
    }
}
