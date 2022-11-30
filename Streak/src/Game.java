import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    /*
    AUTHOR : Jack McArdle
             B00733578
             mcardle-j9@ulster.ac.uk

    This class acts as the main game logic class, the "house" aka dealer.
     */
    static String[] scoreboard;
    static Singleplayer sp = new Singleplayer();
    static Multiplayer mp = new Multiplayer();

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Please choose from the options available
                (1) Single player
                (2) Two player
                (3) Scores
                (4) Exit""");
        String userInput = scan.nextLine();
        switch (userInput) {
            case "1" -> sp.play();
            case "2" -> mp.play();
            case "3" -> System.out.println("Need to make leaderboard");
            case "4" -> {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }

    public Player createPlayer (){
        String playerName;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name > ");
        return new Player(playerName = scan.nextLine(), 0);
    }

    public int chooseHandSize(){
        Hand<Card> HAND = new Hand<Card>(); //for fetching hand size
        int handSize = 0;
        while(true){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please choose the size of your hand. (Between 5-10 cards) > ");
                handSize = scan.nextInt();
                if(handSize < HAND.getDefaultCapacity() || handSize > HAND.getMaxCapacity()){ // hand size range based
                    System.out.println("Please ensure hand is between 5-10 cards in size.");  // on default and max cap
                }
                else break;
            }catch (InputMismatchException ex){
                System.out.println("Please enter valid input.");
            }
        }
        return handSize;
    }

    public int maxStreak(Hand<Card> hand, int handSize){
        int maxStreak = 1, streak = 1, bonusStreak = 1, bonus = 0;
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
                }
                if (colourBonusActive){ // if the compared cards are streaked AND the same colour
                    bonusStreak++;
                    bonus = 1;
                }
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

    public boolean swapCard(Hand<Card> hand, Deck<Card> deck, int swapsLeft, int handSize){ // player needs to be able to exit game with current streak
        char lower = (char)65; //lower bound (A) //rather than having to do all swaps
        int difference = 65 + handSize;
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
