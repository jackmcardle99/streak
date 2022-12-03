import java.util.EmptyStackException;
import java.util.Random;

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

    private void playHand(Player player){
        int maxStreak = game.calculateStreak(hand, handSize);
        try{
            int swaps = handSize; // amount of rounds is equal to hand size
            printUI(player);
            boolean cont = true;
            while(swaps > 0){
                cont = game.swapCard(hand, deck, swaps, handSize); // if false returned, round ends
                if(!cont){
                    if(maxStreak > player.getPlayerScore()) player.setPlayerScore(maxStreak);
                    break;
                }
                swaps--;
                hand.sort(handSize);
                printUI(player);
                if(maxStreak > player.getPlayerScore()) player.setPlayerScore(maxStreak);
            }
        }catch (EmptyStackException e){
            System.out.println("Error occurred. Returning to menu.");
            Game.menu();
        }
    }

    private void spStart(){
        initialiseHand();
        playHand(playerOne);
    }

    private void mpStart(){
        if(playerOneStarts()){
            playThreeRounds(playerOne);
            initialiseDeck();
            playThreeRounds(playerTwo);
        }else{
            playThreeRounds(playerTwo);
            initialiseDeck();
            playThreeRounds(playerOne);
        }

        if(playerOne.compareTo(playerTwo) > 0) System.out.println(playerOne.getPlayerName() + " WINS!");
        else if(playerOne.compareTo(playerTwo) < 0) System.out.println(playerTwo.getPlayerName() + " WINS!");
        else System.out.println("It's a DRAW!");

    }

    private void playThreeRounds(Player player){
        for(int i = 0; i < 3; i++){
            System.out.println("Round " + (i+1) + " of 3");
            initialiseHand();
            playHand(player);
        }
        System.out.println(player.getPlayerName() + " obtained high score of " + player.getPlayerScore());
    }

    private boolean playerOneStarts(){
        Random ran = new Random();
        int result = ran.nextInt(1,3);
        if(result==1){
            System.out.println(playerOne.getPlayerName() + " starts!");
            return true;
        }
        else{
            System.out.println(playerTwo.getPlayerName() + " starts!");
            return false;
        }
    }

    private void printUI(Player player){
        int maxStreak = game.calculateStreak(hand, handSize);
        System.out.println("Player  : " + player.getPlayerName() );
        hand.display();
        System.out.println("\nMax streak  :  " + maxStreak);
    }


    public int getHandSize() {
        return handSize;
    }
}
