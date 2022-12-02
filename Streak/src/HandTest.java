public class HandTest {
    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();

    public static void main(String[] args){
        fillDeck();
        deck.display();
        deck.shuffle();
        deck.display();
        //fillHand();
        hand.display();
       // System.out.println(calculateStreak(hand,5));
    }
    public static int calculateStreak(Hand<Card> hand, int handSize){
        int maxStreak = 1, streak = 1, bonusStreak = 1, bonus = 0;
        Card[] arr = hand.toArray(handSize);
        Card card1 = arr[0], card2;
        boolean suitBonusActive = false, colourBonusActive = false;
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
            if (card1.compareTo(card2) > 0) {
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
    private static void fillDeck(){
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                deck.stash(new Card(rank, suit));
            }
        }
    }
    private static Card[] toArray(Deck<Card> deck){
        Card[] tempArr = new Card[52];
        for(int i = 0; i < 52; i++){
            tempArr[i] = (Card) deck.deal();
        }
        return tempArr;
    }
    private static void fillHand(){
        Card[] arr = toArray(deck);
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            System.out.println("Index: " + count + " | Card = " + arr[i]);
            count++;
        }
        //hand.stash(arr[26]);



        hand.stash(arr[40]);
        hand.stash(arr[41]);
        hand.stash(arr[16]);
        hand.stash(arr[48]);
        hand.stash(arr[36]);

       // hand.stash(arr[38]);


//        hand.stash(arr[43]);
//        hand.stash(arr[44]);
//        hand.stash(arr[45]);
//        hand.stash(arr[46]);
//        hand.stash(arr[47]);
//        hand.stash(arr[48]);
//        hand.stash(arr[49]);
//        hand.stash(arr[50]);
//        hand.stash(arr[51]);




//        hand.stash(arr[29]); // <---- this is jack of hearts
//        hand.stash(arr[42]); // <----- this is jack of clubs
//        //hand.stash(arr[36]);
////        hand.stash(arr[26]);
////        hand.stash(arr[27]);
////        hand.stash(arr[28]);
//        hand.stash(arr[50]);

    }

    public void toPutIntoTestClass(){
        System.out.println("-----------------------------UNSHUFFLED---------------------");
        for(int i = 0; i < deck.MAX_CAPACITY; i++){
            System.out.println(deck.deal());
        }

         deck.clear();
        //fillDeck();
         deck.shuffle();
        System.out.println("-----------------------------SHUFFLED---------------------");
        Card card1 = deck.deal();
        Card card2 = deck.deal();
        System.out.println("Card 1 is " + card1 + " rank order is " + card1.getRankValue());
        System.out.println("Card 2 is " + card1 + " rank order is " + card1.getRankValue());
        System.out.println(card1.compareTo(card2));
        for(int i = 0; i < deck.MAX_CAPACITY; i++){
            System.out.println(deck.deal());
        }

        // System.out.println("Card is: " + card1 + " and is black " + card1.isBlack());
    }
}
