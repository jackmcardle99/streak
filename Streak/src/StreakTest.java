import java.util.Scanner;

public class StreakTest {
    /*
    This class if for testing the main features of the streak game. Swapping cards, creating players and calculating
    the streak.
     */

    public static void main(String[] args){
        System.out.println("TESTING PLAYER OBJECTS........\n");
        testPlayers();
        System.out.println("\n\n\nTESTING STREAK CALCULATION........\n");
        testStreak();
        System.out.println("\n\n\nTESTING CARD SWAPPING.........\n");
        testSwap();
    }

    // method testing creating and updating of user scores
    public static void testPlayers(){
        Player player1 = new Player("Jack", 0);
        Player player2 = new Player("Sarah", 1);
        System.out.println("Player name = " + player1.getPlayerName() + "\nPlayer score = " + player1.getPlayerScore());
        System.out.println("\nPlayer name = " + player2.getPlayerName() + "\nPlayer score = " + player2.getPlayerScore());
        System.out.println("\n Updating scores...");
        player1.setPlayerScore(5);
        player2.setPlayerScore(6);
        System.out.println("\nPlayer name = " + player1.getPlayerName() + "\nPlayer score = " + player1.getPlayerScore());
        System.out.println("\nPlayer name = " + player2.getPlayerName() + "\nPlayer score = " + player2.getPlayerScore());
    }

    public static void testStreak(){
        Deck<Card> deck = new Deck<>();
        Hand<Card> hand = new Hand<>();
        deck.fill();
        Card[] deckArr = new Card[52];
        for(int i = 0; i < deck.MAX_CAPACITY; i++){
            deckArr[i] = deck.deal();
        }
        int count = 0;
        for(Card cards : deckArr){
            System.out.println("Index " + count + " : " + cards);
            count++;
        }
        System.out.println("\n\nTesting streak of 5 same suit...\n");
        hand.stash(deckArr[40]);
        hand.stash(deckArr[41]);
        hand.stash(deckArr[42]);
        hand.stash(deckArr[43]);
        hand.stash(deckArr[44]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,5));
        hand.clear();

        System.out.println("\n\nTesting streak of 10 same suit...\n");
        hand.stash(deckArr[40]);
        hand.stash(deckArr[41]);
        hand.stash(deckArr[42]);
        hand.stash(deckArr[43]);
        hand.stash(deckArr[44]);
        hand.stash(deckArr[45]);
        hand.stash(deckArr[46]);
        hand.stash(deckArr[47]);
        hand.stash(deckArr[48]);
        hand.stash(deckArr[49]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,10));
        hand.clear();

        System.out.println("\n\nTesting streak of 5 mixed cards...\n");
        hand.stash(deckArr[0]);
        hand.stash(deckArr[40]);
        hand.stash(deckArr[28]);
        hand.stash(deckArr[42]);
        hand.stash(deckArr[4]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,5));
        hand.clear();

        System.out.println("\n\nTesting streak of 2 of same colour...\n");
        hand.stash(deckArr[0]);
        hand.stash(deckArr[32]);
        hand.stash(deckArr[9]);
        hand.stash(deckArr[36]);
        hand.stash(deckArr[4]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,5));
        hand.clear();

        System.out.println("\n\nTesting streak of 3 of same colour...\n");
        hand.stash(deckArr[0]);
        hand.stash(deckArr[32]);
        hand.stash(deckArr[9]);
        hand.stash(deckArr[36]);
        hand.stash(deckArr[11]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,5));
        hand.clear();

        System.out.println("\n\nTesting streak with same card in between...\n");
        hand.stash(deckArr[0]);
        hand.stash(deckArr[32]);
        hand.stash(deckArr[9]);
        hand.stash(deckArr[36]);
        hand.stash(deckArr[36]);
        hand.stash(deckArr[11]);
        hand.display();
        System.out.println("\nStreak of : " + calculateStreak(hand,5));
        hand.clear();
    }

    public static void testSwap(){
        Deck<Card> deck = new Deck<>();
        Hand<Card> hand = new Hand<>();
        deck.fill();
        deck.shuffle();
        hand.fill(5, deck);
        hand.display();
        int swaps = 5;
        while(swaps > 0){
            swapCard(hand, deck, swaps, 5);
            swaps--;
            hand.display();
        }
    }

    private static int calculateStreak(Hand<Card> hand, int handSize){
        int maxStreak = 1, streak = 1, bonusStreak = 1, bonus = 0;
        Card[] arr = hand.toArray(handSize);
        Card card1 = arr[0], card2;
        boolean suitBonusActive, colourBonusActive;
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
            if (card1.compareTo(card2) > 0 || card1.compareTo(card2) == 0) {
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
    private static void swapCard(Hand<Card> hand, Deck<Card> deck, int swapsLeft, int handSize){ // player needs to be able to exit game with current streak
        char lower = (char)65; //lower bound (A) //rather than having to do all swaps
        int difference = 65 + handSize;
        char upper = (char)difference; // upperbound (J)
        while(true){
            Scanner scan = new Scanner(System.in);
            char userChar;
            System.out.println("\nTo swap a card, enter the equivalent letter. " + swapsLeft + " swaps left >");
            userChar = scan.next().charAt(0);
            if(userChar == 'T' || userChar == 't'){
                return;
            }
            if(userChar < lower || userChar > upper){
                System.out.println("Please enter valid letter.");
            }
            else {
                Card[] arr = hand.toArray(handSize);
                arr[userChar-65] = deck.deal();
                hand.arrToStack(arr);
                return;
            }
        }
    }
}
