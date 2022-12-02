import java.util.EmptyStackException;

public class Streak {

    private final Game game = new Game();
    private Player playerOne, playerTwo;
    private final Deck<Card> deck = new Deck<>();
    private final Hand<Card> hand = new Hand<>();
    private int handSize;

    public Streak(){}

    public void play(boolean singleplayer){
        setUp(singleplayer);
        if(singleplayer) spStart();
        else mpStart();
    }

    private void setUp(boolean singleplayer){
        try {
            System.out.println("PLAYER ONE:");
            playerOne = game.createPlayer();
            if(!singleplayer){
                System.out.println("PLAYER TWO:");
                playerTwo = game.createPlayer();
            }
            handSize = game.chooseHandSize();
            initialiseDeck();
            initialiseHand();
        }catch (EmptyStackException e){
            System.out.println("Failed to set up. Returning to menu.");
            Game.menu();
        }
    }

    private void initialiseDeck(){
        deck.clear();
        deck.fill();
        deck.shuffle();
    }
    private void initialiseHand(){
        hand.clear();
        hand.fill(handSize, deck);
        hand.sort(handSize);
    }

    private void spStart(){ // THIS METHOD COULD POTENTIALLY RETURN PLAYER OBJECT TO ADD TO SCOREBOARD
        int maxStreak = game.calculateStreak(hand, handSize);
        try{
            int swaps = handSize; // amount of rounds is equal to hand size
            System.out.println("Player  : " + playerOne.getPlayerName() );
            hand.display();
            System.out.println("\nMax streak  :  " + maxStreak);
            boolean cont = true;
            while(swaps > 0){
                cont = game.swapCard(hand, deck, swaps, handSize); // if false returned, round ends
                if(!cont) break;
                swaps--;
                hand.sort(handSize);
                maxStreak = game.calculateStreak(hand, handSize);
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

    private void mpStart(){
        System.out.println("YAY multiplayer starting!");
        System.out.println("Player One " + playerOne.getPlayerName());
        System.out.println("Player One " + playerTwo.getPlayerName());

        //player one plays their 3 hands
        playerOne.setPlayerScore(4); //whatever their highest streak is, set playerscoer


        playerTwo.setPlayerScore(5);
    }

    public int getHandSize() {
        return handSize;
    }
}
