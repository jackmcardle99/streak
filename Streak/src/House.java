import java.util.InputMismatchException;
import java.util.Scanner;

public class House {

    /*
    AUTHOR : Jack McArdle
             B00733578
             mcardle-j9@ulster.ac.uk

    This class acts as the main game logic class, the "house" aka dealer.
     */

    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();
    static String[] scoreboard;

    public static void main(String[] args){
        menu();
    }

    private static void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Please choose from the options available
                (1) Single player
                (2) Two player
                (3) Scores
                (4) Exit""");
        String userInput = scan.nextLine();
        switch (userInput) {
            case "1" -> singlePlayer();
            case "2" -> twoPlayer();
            case "3" -> scoreboard();
            case "4" -> {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }

    public static void singlePlayer(){
        String playerName = createPlayer();
        deck.fill();
        deck.shuffle();
        hand.fill(chooseHandSize(),deck);
        hand.sort();
        play(playerName,null);
    }

    public static void play(String playerOne, String playerTwo){
        int swaps = hand.getCapacity(); // amount of rounds is equal to hand size
        System.out.println("Player  : " + playerOne );
        System.out.println("\nMax streak  :  " + maxStreak());
        hand.display();
        boolean cont = true;
        while(swaps > 0){
            cont = swapCard(swaps); // if false returned, round ends
            if(!cont) break;
            swaps--;
            hand.sort();
            System.out.println("Player  : " + playerOne );
            System.out.println("\nMax streak  :  " + maxStreak());
            hand.display();
        }
        // SAVE THE SCORE TO SCOREBOARD FROM HERE IF IT IS ABOVE CURRENT PLAYERS
        System.out.println("DONE");
    }

    public static void twoPlayer(){}

    public static void scoreboard(){}


    private static String createPlayer (){
        String playerName;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name > ");
        return playerName = scan.nextLine();
    }

    private static int chooseHandSize(){
        int handSize = 0;
        while(true){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please choose the size of your hand. (Between 5-10 cards) > ");
                handSize = scan.nextInt();
                if(handSize < hand.getDefaultCapacity() || handSize > hand.getMaxCapacity()){ // hand size range based
                    System.out.println("Please ensure hand is between 5-10 cards in size.");  // on default and max cap
                }
                else break;
            }catch (InputMismatchException ex){
                System.out.println("Please enter valid input.");
            }
        }
        return handSize;
    }

    private static int maxStreak(){
        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, bonusStreak = 1, bonus = 0;
        Card[] arr = hand.toArray();
        Card card1 = arr[0], card2;
        boolean suitBonusActive = false, colourBonusActive = false;
        for(int i = 1; i < handSize; i++) {
            card2 = arr[i];
            suitBonusActive = card1.getSuit().equals(card2.getSuit()); //true if suits are same
            colourBonusActive = card1.getColour().equals(card2.getColour()); //true if compared cards are same colour

            ///////////////////// THIS DECISION STRUCTURE APPLIES IF CARD2 IS + 1 TO CARD1 ////////////////////////
            if (card1.compareTo(card2) < 0) {
                streak++; // add one to streak
                if (suitBonusActive){ // if the compared cards are streaked AND they are the same suit
                    bonusStreak++; // create new streak counter and increment
                    colourBonusActive = false; // if card are same suit, then colour bonus is irrelevant
                    bonus = 2;
                    //bonusStreak = bonusStreak + 2; //bonus streak comprises new streak and bonus points
                    System.out.println("\nsuit BONUS " + (bonusStreak+2) + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
                }
                if (colourBonusActive){ // if the compared cards are streaked AND the same colour
                    bonusStreak++;
                    bonus = 1;
//                    bonusStreak++;
                    System.out.println("\nColour BONUS " + (bonusStreak+1) + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
                }
                System.out.println("ORDINARY STREAK = " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////// THIS DECISION STRUCTURE APPLIES IF CARDS ARE NOT STREAKED ////////////////////////
            if (card1.compareTo(card2) > 0) {
                streak = 1; // reset streak values
                bonusStreak = 1;
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////

            // Determine which type of streak is greater, then update max streak with new value
            if((bonusStreak+bonus) > maxStreak || streak > maxStreak){
                maxStreak = Math.max((bonusStreak+bonus), streak);
            }
            card1 = card2; // update next set of cards to be compared
        }
        hand.arrToStack(arr);
        return maxStreak;
    }

    private static boolean swapCard(int swapsLeft){ // player needs to be able to exit game with current streak
        char lower = (char)65; //lower bound (A) //rather than having to do all swaps
        int difference = 65 + hand.getCapacity();
        char upper = (char)difference; // upperbound (J)
        while(true){
            Scanner scan = new Scanner(System.in);
            char userChar;
            System.out.println("\nIf you'd like to swap a card, enter the equivalent letter. " +
                    "Otherwise press T to exit and save your streak. You have " + swapsLeft + " swaps left >");
            userChar = scan.next().charAt(0);
            if(userChar == 'T' || userChar == 't'){
                return false; //
            }
            if(userChar < lower || userChar > upper){
                System.out.println("Please enter valid letter.");
            }
            else {
                Card[] arr = hand.toArray();
                //arr[cardToSwap] = replay.stash(); // FOR REPLAY deck LATER
                arr[userChar-65] = deck.deal();
                hand.arrToStack(arr);
                return true;
            }
        }
    }
}
