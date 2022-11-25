import java.util.InputMismatchException;
import java.util.Scanner;

public class House {
    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();
    //this class will act as main class, house aka dealer.
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
        Card[] myCards = new Card[52];
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                 deck.stash(new Card(rank, suit));
            }
        }
    }

    public static void onePlayer(){
        fillDeck();
        //System.out.println("-----------------------------UNSHUFFLED---------------------");
//        for(int i = 0; i < deck.MAX_CAPACITY; i++){
//            System.out.println(deck.deal());
//        }

       // deck.clear();
        //fillDeck();
       // deck.shuffle();
        //System.out.prijntln("-----------------------------SHUFFLED---------------------");
        deck.shuffle();
//        Card card1 = deck.deal();
//        Card card2 = deck.deal();
//        System.out.println("Card 1 is " + card1 + " rank order is " + card1.getRankValue());
//        System.out.println("Card 2 is " + card1 + " rank order is " + card1.getRankValue());
//        System.out.println(card1.compareTo(card2));
//        for(int i = 0; i < deck.MAX_CAPACITY; i++){
//            System.out.println(deck.deal());
//        }

        fillHand(chooseHandSize());
        hand.display();
        System.out.println(hand.getCapacity());
        hand.quickSort(hand.getCapacity());
       // System.out.println(deck.getCapacity());
    }

    public static void twoPlayer(){};

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






}
