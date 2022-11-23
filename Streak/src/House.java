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
        switch (userInput){
            case "1":
                fillDeck();
                onePlayer();
        }
//        System.out.println("♠");
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
        fillHand(chooseHandSize());

    }

    public static void twoPlayer(){};

    private static int chooseHandSize(){
        //TRY CATCH IN HERE
        //VALIDATION TO ENSURE HAND IS 5-10
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose the size of your hand. (Between 5-10 cards)");
        return scan.nextInt();
    }
    private static void fillHand(int handSize){
        for(int i = 0; i < handSize; i++){
            hand.stash(deck.deal());
        }
    }




}
