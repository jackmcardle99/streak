import java.util.Scanner;

public class Menu {

    /*
    AUTHOR : Jack McArdle
             B00733578
             mcardle-j9@ulster.ac.uk

    This class is the main class of the application, and acts as a menu for accessing different parts of the game. No
    game logic is defined here.
     */

    private static final Scoreboard<Player> scoreTable = new Scoreboard<>();

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

    public static void printScoreboard(){
        if(scoreTable.isEmpty()){
            System.out.println("No high scores yet!");
            menu();
        }
        int size = scoreTable.getNumberOfEntries();  // I NEED TO ENQUEUE THE PLAYER OBJECTS AFTER DISPLAYING TABLE!!!!!!
        //Player[] temp = new Player[]
        String[][] table = new String[size][2];     // SO THAT THE PRIORITYQUEUE WILL RE-POPULATE
        for(int i = 0; i < size; i++){
            if(scoreTable.getFront()==null) break;
            table[i] = new String[]{scoreTable.getFront().getPlayerName(), String.valueOf(scoreTable.getFront().getPlayerScore())};
            scoreTable.dequeue();
        }
        System.out.println("PLAYER                        SCORE");
        System.out.println("-----------------------------------");
        for (final Object[] row : table) {
            System.out.format("%-30s%-30s%n", row);
        }
    }

    public void addToTable(Player playerToAdd){
        scoreTable.enqueue(playerToAdd);
    }

    public Player createPlayer (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name > ");
        return new Player(scan.nextLine(), 0);
    }
}
