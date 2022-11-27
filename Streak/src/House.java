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

    private static void fillDeck(){
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                 deck.stash(new Card(rank, suit));
            }
        }
    }

    public static void singlePlayer(){
        String playerName = createPlayer();
        fillDeck();
        deck.shuffle();
        fillHand(chooseHandSize());
        hand.sort();
        play(playerName,null);
    }

    public static void play(String playerOne, String playerTwo){
        int swaps = hand.getCapacity(); // amount of rounds is equal to hand size
        do{
            System.out.println("Player  : " + playerOne );
            hand.display();
            System.out.println("\nMax streak  :  " + maxStreak());
            swapCard(swaps);
            swaps--;
        }while(swaps >= 0);
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
    private static void fillHand(int handSize){
        for(int i = 0; i < handSize; i++){
            hand.stash(deck.deal());
        }
    }

//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 0, suitCount = 0;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//            if (card1.compareTo(card2) < 0) { // if adjacent cards are the streaked
//                streak++;
//                if (card1.getSuit().equals(card2.getSuit())) {
//                    suitCount++;
//                }
//                if (card1.getColour().equals(card2.getColour())) {
//                    colourCount++;
//                }
//            }
//            if (card1.compareTo(card2) > 0) { // if the cards are not streaked, then reset streak counter and
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//            }
//            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
//                maxStreak = streak;
//            }
//            int currStreak = maxStreak; // temp variable to compare suit and colour count against
//            if(colourCount == currStreak-1 && colourCount!= 0) maxStreak = maxStreak + 1;
//            if(suitCount >= currStreak-1 && colourCount!= 0) maxStreak = maxStreak+2;
//            card1 = card2;
//        }
//        hand.arrToStack(arr);
//        return maxStreak;
//    }

    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 0, suitCount = 0;
        Card[] arr = hand.toArray();
        Card card1 = arr[0], card2;
        for(int i = 1; i < handSize; i++) {
            card2 = arr[i];
            if (card1.compareTo(card2) < 0) { // if adjacent cards are the streaked
                streak++;
                if (card1.getSuit().equals(card2.getSuit())) {
                    suitCount++;
                }
                if (card1.getColour().equals(card2.getColour())) {
                    colourCount++;
                }
            }
            if (card1.compareTo(card2) > 0) { // if the cards are not streaked, then reset streak counter and
                streak = 1;                   // reset counter for same colour/suit
                colourCount = 0;
                suitCount = 0;
            }

            int currStreak = streak; // temp variable to compare suit and colour count against
            if(colourCount == currStreak-1 && colourCount!= 0) streak = streak + 1;
            if(suitCount >= currStreak-1 && colourCount!= 0) streak = streak+2;
            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
                maxStreak = streak;
            }
            card1 = card2;
        }
        hand.arrToStack(arr);
        return maxStreak;
    }

    private static void swapCard(int swapsLeft){
        char lower = (char)65; //lower bound (A)
        int difference = 65 + hand.getCapacity();
        char upper = (char)difference; // upperbound (J)
        while(true){
            Scanner scan = new Scanner(System.in);
            char userChar;
            System.out.println("\nIf you'd like to swap a card, enter the equivalent letter. You have " + swapsLeft + " swaps left >");
            userChar = scan.next().charAt(0);
            if(userChar < lower || userChar > upper){
                System.out.println("Please enter valid letter.");
            }
            else {
                Card[] arr = hand.toArray();
                //arr[cardToSwap] = replay.stash(); // FOR REPLAY deck LATER
                arr[userChar-65] = deck.deal();
                hand.arrToStack(arr);
                break;
            }
        }
    }
}
