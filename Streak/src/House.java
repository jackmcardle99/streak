import jdk.swing.interop.SwingInterOpUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class House {
    /*
    This class acts as the main game logic class, the "house" aka dealer.
     */
    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();

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
            case "1" -> onePlayer();
            case "2" -> twoPlayer();
            case "3" -> scoreboard();
            case "4" -> {
                System.out.println("Thanks for playing!");
                System.exit(1);
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

    public static void onePlayer(){
        Scanner scan = new Scanner(System.in);
        String userInput;
        fillDeck();
        deck.shuffle();
        fillHand(chooseHandSize());
        hand.sort();
        hand.display();
        System.out.println("Max streak = " + maxStreak());
        //while(true){
//            System.out.println("Would you like to swap a card? (Y/N)");
//            userInput = scan.nextLine();

        //}
    }

    public static void twoPlayer(){}

    public static void scoreboard(){}

    private static int chooseHandSize(){
        //TRY CATCH IN HERE
        //VALIDATION TO ENSURE HAND IS 5-10
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Please choose the size of your hand. (Between 5-10 cards)");
            return scan.nextInt();
        }catch (InputMismatchException ex){
            System.out.println("Please enter valid input");
        }
        return 0;
    }
    private static void fillHand(int handSize){
        for(int i = 0; i < handSize; i++){
            hand.stash(deck.deal());
        }
    }

//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 1, suitCount = 1;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//            if (card1.compareTo(card2) < 0) {
//                streak++;
//                if (card1.isSameSuit(card2)) {
//                    System.out.println("SAME SUIT!");
//                    suitCount++;
//                }
//                if (card1.getColour().equals(card2.getColour())) {
//                    System.out.println("SAME COLOUR!");
//                    colourCount++;
//                }
//            }
//            if (card1.compareTo(card2) > 0) {
//                streak = 1;
//                colourCount = 1;
//                suitCount = 1;
//            }
//            if(streak > maxStreak){
//                maxStreak = streak;
//            }
//            card1 = card2;
//        }
//       // if(colourCount == streak) maxStreak++;
//        //if(suitCount == streak) maxStreak = maxStreak+2;
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
            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
                maxStreak = streak;
            }
            int currStreak = maxStreak; // temp variable to compare suit and colour count against
            if(colourCount == currStreak-1 && colourCount!= 0) maxStreak = maxStreak + 1;
            if(suitCount == currStreak-1 && colourCount!= 0) maxStreak = maxStreak+2;
            card1 = card2;
        }
        return maxStreak;
    }


    public void toPutIntoTestClass(){
        //System.out.println("-----------------------------UNSHUFFLED---------------------");
//        for(int i = 0; i < deck.MAX_CAPACITY; i++){
//            System.out.println(deck.deal());
//        }

        // deck.clear();
        //fillDeck();
        // deck.shuffle();
        //System.out.prijntln("-----------------------------SHUFFLED---------------------");
//        Card card1 = deck.deal();
//        Card card2 = deck.deal();
//        System.out.println("Card 1 is " + card1 + " rank order is " + card1.getRankValue());
//        System.out.println("Card 2 is " + card1 + " rank order is " + card1.getRankValue());
//        System.out.println(card1.compareTo(card2));
//        for(int i = 0; i < deck.MAX_CAPACITY; i++){
//            System.out.println(deck.deal());
//        }

       // System.out.println("Card is: " + card1 + " and is black " + card1.isBlack());
    }
}
