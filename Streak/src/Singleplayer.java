import java.util.EmptyStackException;

public class Singleplayer{

    private final Game game = new Game();
    private Player playerOne, playerTwo;
    private final Deck<Card> deck = new Deck<>();
    private final Hand<Card> hand = new Hand<>();
    private int handSize;

    public Singleplayer(){}

    public void play(){
        setUp();
        startGame();
    }

    private void setUp(){
        try {
            playerOne = game.createPlayer();
            handSize = game.chooseHandSize();
            deck.fill();
            deck.shuffle();
            hand.fill(handSize, this.deck);
            hand.sort();
            hand.display();
        }catch (EmptyStackException e){
            System.out.println("Failed to set up. Returning to menu.");
            Game.menu();
        }
    }

    private void startGame(){ // THIS METHOD COULD POTENTIALLY RETURN PLAYER OBJECT TO ADD TO SCOREBOARD
        int maxStreak = game.maxStreak(hand, handSize);
        try{
            int swaps = handSize; // amount of rounds is equal to hand size
            System.out.println("Player  : " + playerOne.getPlayerName() );
            System.out.println("\nMax streak  :  " + maxStreak);
            hand.display();
            boolean cont = true;
            while(swaps > 0){
                cont = game.swapCard(hand, deck, swaps, handSize); // if false returned, round ends
                if(!cont) break;
                swaps--;
                hand.sort();
                maxStreak = game.maxStreak(hand, handSize);
                System.out.println("Player  : " + playerOne.getPlayerName() );
                System.out.println("\nMax streak  :  " + maxStreak);
                hand.display();
            }
            // SAVE THE SCORE TO SCOREBOARD FROM HERE IF IT IS ABOVE CURRENT PLAYERS
            System.out.println("Your max streak was   :   " + maxStreak + ". Returning to menu...");
            playerOne.setPlayerScore(maxStreak);
            Game.menu();
        }catch (EmptyStackException e){
            System.out.println("Error occurred. Returning to menu.");
            Game.menu();
        }
    }
}
