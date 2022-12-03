import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;

public class Streak {

    private final Game game = new Game();
    private Player playerOne, playerTwo;
    private final Deck<Card> deck = new Deck<>();
    private final Hand<Card> hand = new Hand<>();
    private final Replay<Hand<Card>> replay = new Replay<>();
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
            System.out.println("\nFailed to set up. Returning to menu.");
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

    private void playHand(Player player, boolean replay){
        int maxStreak = game.calculateStreak(hand, handSize);
        try{
            int swaps = handSize; // amount of rounds is equal to hand size
            printUI(player);
            boolean cont;
            while(swaps > 0){
                cont = game.swapCard(hand, deck, swaps, handSize); // if false returned, round ends
                if(!cont){
                    if(maxStreak > player.getPlayerScore()) player.setPlayerScore(maxStreak);
                    break;
                }
                swaps--;
                hand.sort(handSize);
                createReplay();
                printUI(player);
                if(maxStreak > player.getPlayerScore()) player.setPlayerScore(maxStreak);
            }
        }catch (EmptyStackException e){
            System.out.println("\nError occurred. Returning to menu.");
            Game.menu();
        }
    }

    private void spStart(){
        initialiseHand();
        createReplay(); // creates copy of original hand
        playHand(playerOne, true);
        if(viewReplay()) printReplay();
    }

    private void createReplay(){
          Card[] replayArr = hand.toArray(handSize); // Current hand copied to array
          hand.arrToStack(replayArr); // hand array must be put back into hand stack
          Hand<Card> replayHand = new Hand<>(); // creating a new stack as copy
          replayHand.arrToStack(replayArr);
          replay.enqueue(replayHand); // enqueuing each hand as they're played into the replay queue
    }

    private boolean viewReplay(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPress (Y) for replay, otherwise press any other button to return to menu.");
        String response = scan.nextLine();
        return response.equals("Y") || response.equals("y");
    }

    private void printReplay(){
        Scanner scan = new Scanner(System.in);
        int count = 0;
        try {
            while (count != handSize) {
                count++;
                System.out.println(playerOne.getPlayerName() + " Round " + count);
                replay.dequeue().display();
                System.out.println("\n(Any button to continue...) >");
                String input = scan.nextLine();
            }
        }catch (NullPointerException ex){
            System.out.println("\n\nReplay done!\n\n");
        }

//        int count = 0;
//        while(!replay.isEmpty()){
//            count++;
//            System.out.println("HAND NO." + count);
//            replay.getFront().display();
//            replay.dequeue();
//            if(replay.isEmpty()) break;
//        }

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
            playHand(player, false);
        }
        System.out.println(player.getPlayerName() + " obtained high score of " + player.getPlayerScore());
    }

    private boolean playerOneStarts(){ // this method is used to randomise who starts during two player game
        Random ran = new Random();
        int result = ran.nextInt(1,3);
        if(result==1){
            System.out.println("\n" + playerOne.getPlayerName() + " starts!");
            return true;
        }
        else{
            System.out.println("\n" + playerTwo.getPlayerName() + " starts!");
            return false;
        }
    }

    private void printUI(Player player){
        int maxStreak = game.calculateStreak(hand, handSize);
        System.out.println("Player  : " + player.getPlayerName() + "\n");
        hand.display();
        System.out.println("\nMax streak  :  " + maxStreak);
    }
}
