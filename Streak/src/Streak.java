import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Streak {
    /*
    This class is the game logic class, it provides methods that define behaviours to control the flow of the game.
     */

    private final Menu menu = new Menu();
    private Player playerOne, playerTwo;
    private final Deck<Card> deck = new Deck<>();
    private final Hand<Card> hand = new Hand<>();
    private final Replay<Hand<Card>> replay = new Replay<>(); // replay queue for holding hands
    private final Replay<Card> swapReplay = new Replay<>(); // replay queue for holding swapped cards
    private int handSize; // instance variable used for determining size of each played hand

    public Streak(){}

    public void play(boolean singleplayer){
        setUp(singleplayer);
        if(singleplayer) spStart();
        else mpStart();
    }

    private void setUp(boolean singleplayer){
        try {
            System.out.println("PLAYER ONE:");
            playerOne = Player.createPlayer();
            if(!singleplayer){
                System.out.println("PLAYER TWO:");
                playerTwo = Player.createPlayer();
            }
            handSize = chooseHandSize();
            initialiseDeck();
        }catch (EmptyStackException e){
            System.out.println("\nFailed to set up. Returning to menu.");
            Menu.menu();
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

    private int playHand(Player player){
        int maxStreak = 1;
        try{
            int swaps = handSize; // amount of rounds is equal to hand size
            printUI(player);
            boolean cont;
            while(swaps > 0){
                maxStreak = calculateStreak();
                cont = swapCard(hand, deck, swaps, handSize); // if false returned, round ends
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
            Menu.menu();
        }
        return  maxStreak;
    }

    private void spStart(){
        initialiseHand();
        createReplay();
        playHand(playerOne);
        if(viewReplay()) printReplay();
        menu.addToScoreboard(playerOne);
        replay.clear(); // need to clear replay at the end
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
            while (!replay.isEmpty()) {
                count++;
                System.out.println(playerOne.getPlayerName() + " Round " + count);
                replay.dequeue().display();
                System.out.println("\n\n Selection was " + swapReplay.dequeue().toString());
                System.out.println("\n(Any button to continue...) >");
                scan.nextLine();
            }
        }catch (NullPointerException ex){
            System.out.println("\n\nReplay done!\n\n");
        }
    }

    private void mpStart(){
        int playerOneCumulative, playerTwoCumulative;
        if(playerOneStarts()){
            playerOneCumulative = playThreeRounds(playerOne);
            initialiseDeck();
            playerTwoCumulative = playThreeRounds(playerTwo);
        }else{
            playerTwoCumulative = playThreeRounds(playerTwo);
            initialiseDeck();
            playerOneCumulative = playThreeRounds(playerOne);
        }
        if(playerOneCumulative > playerTwoCumulative) System.out.println("\n" + playerOne.getPlayerName() + " WINS!\n\n");
        if(playerTwoCumulative > playerOneCumulative) System.out.println("\n" + playerTwo.getPlayerName() + " WINS!\n\n");
        else if (playerOneCumulative == playerTwoCumulative) System.out.println("\nIT'S A DRAW!\n\n");
        menu.addToScoreboard(playerOne); //adding players to scoreboard
        menu.addToScoreboard(playerTwo);
    }

    private int playThreeRounds(Player player){
        int combinedScore = 0;
        for(int i = 0; i < 3; i++){
            System.out.println("Round " + (i+1) + " of 3");
            initialiseHand();
            combinedScore += playHand(player); // assigning max streak to current score
        }
        System.out.println(player.getPlayerName() + " obtained total score of " + combinedScore);
        return combinedScore;
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
        int streak = calculateStreak();
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Player  : " + player.getPlayerName() + "\n");
        hand.display();
        System.out.println("\nHighest streak  :  " + streak);
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
    }

    private boolean swapCard(Hand<Card> hand, Deck<Card> deck, int swapsLeft, int handSize){ // player needs to be able to exit game with current streak
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
                return false;
            }
            if(userChar < lower || userChar > upper){
                System.out.println("Please enter valid letter.");
            }
            else {
                Card[] arr = hand.toArray(handSize);
                swapReplay.enqueue(arr[userChar-65]); // adding swapped card to replay
                arr[userChar-65] = deck.deal();
                hand.arrToStack(arr);
                return true;
            }
        }
    }

    private int calculateStreak(){
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


    private int chooseHandSize(){
        Hand<Card> HAND = new Hand<>(); //for fetching hand size
        int handSize;
        while(true){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please choose the size of the hand being played. (Between 5-10 cards) > ");
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
}
