public class HandTest {
    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();

    public static void main(String[] args){
        fillDeck();
        deck.display();
        fillHand();
        hand.display();
        System.out.println(maxStreak());
    }
//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, suitCount = 0, colourCount = 0;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        boolean CB = false;
//        boolean SB = false;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//
//            if (card1.compareTo(card2) <= 0 ) { // if adjacent cards are the streaked
//                streak++;
//                if (card1.getSuit().equals(card2.getSuit())) {
//                    suitCount++;
//                    System.out.println("\nSuit count " + suitCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                }
//                if (card1.getColour().equals(card2.getColour())) {
//                    colourCount++;
//                }
//                System.out.println("\nCurrent streak " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//            }
//            if (card1.compareTo(card2) > 0) { // if the cards are not streaked, then reset streak counter and
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//            }
//            if (card1.compareTo(card2) > 0) { // if the cards are not streaked, then reset streak counter and
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//                System.out.println("\nCurrent streak " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//            }
//
//            int currStreak = maxStreak; // temp variable to compare suit and colour count against
//            //if(CB) streak++;
//            //if(SB) streak = streak + 2;
//            if(colourCount == currStreak-1 && colourCount!= 0) streak = streak + 1;
//            if(suitCount >= currStreak-1 && colourCount!= 0) streak = streak+2;
//            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
//                maxStreak = streak;
//            }
//            card1 = card2;
//        }
//        hand.arrToStack(arr);
//        return maxStreak;
//    }

//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 0, suitCount = 0;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        boolean sameSuit = false;
//        boolean sameColour = false;
//        boolean sameSuitSameColour =false;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//            if (card1.compareTo(card2) < 0) { // if adjacent cards are the streaked
//                streak++;
//                if (card1.getSuit().equals(card2.getSuit())) {
//                    suitCount++;
//                    sameSuit = true;
//                    System.out.println("\nSuit count " + suitCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                } else if (!card1.getSuit().equals(card2.getSuit())) {
//                    sameSuit = false;
//                }
//                if (card1.getColour().equals(card2.getColour())) {
//                    sameColour = true;
//                }else if (!card1.getColour().equals(card2.getColour())) {
//                    sameColour = false;
//
//            }
//            if (card1.compareTo(card2) > 0) { // if the cards are not streaked, then reset streak counter and
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//            }
//
//            int currStreak = streak; // temp variable to compare suit and colour count against
//            //if(colourCount == currStreak-1 && colourCount!= 0) streak = streak + 1;
//           // if(suitCount >= currStreak-1 && colourCount!= 0) streak = streak+2;
//            if(sameSuit) streak = streak + 2;
//            if(!sameSuit) streak = streak -2;
//            if(sameColour) streak++;
//            if(!sameColour) streak--;
//            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
//                maxStreak = streak;
//            }
//            System.out.println("\nCurrent streak " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//            card1 = card2;
//        }}
//        hand.arrToStack(arr);
//        return maxStreak;
//    }

//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 0, suitCount = 0;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        boolean sameSuit = false;
//        boolean sameColour = false;
//        boolean suitBonusActive =false;
//        boolean colourBonusActive = false;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//            if (card1.compareTo(card2) < 0) { // IF ADJACENT CARDS ARE +1 IN ORDER
//                streak++;
//                if(card1.getSuit().equals(card2.getSuit())){
//                    suitBonusActive =true;
//                    suitCount++;
//                   // System.out.println("\nSuit count " + suitCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                }
//                if (!card1.getSuit().equals(card2.getSuit())) {
//                    suitBonusActive = false;
//                    streak--;
//                }
//                //System.out.println("Same suit bonus = " + sameSuit);
//                if(card1.getColour().equals(card2.getColour())){
//                    colourBonusActive = true;
//                    colourCount++;
//                    //System.out.println("\nColour count " + colourCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                }
//                if (!card2.getColour().equals(card2.getColour())) {
//                    colourBonusActive = false;
//                    //streak--;
//                }
//                //sameColour = card1.getColour().equals(card2.getColour());
//                //System.out.println("Same colour bonus = " + sameColour);
//            }
//            if (card1.compareTo(card2) > 0) { // IF CARDS ARE NOT +1 IN ORDER
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//                colourBonusActive = false;
//                suitBonusActive = false;
//            }
//
//           // int currStreak = streak; // temp variable to compare suit and colour count against
//            //if(colourCount == currStreak-1 && colourCount!= 0) streak = streak + 1;
//            // if(suitCount >= currStreak-1 && colourCount!= 0) streak = streak+2;
////            if(sameSuit && !suitBonusActive)  suitBonusActive = true;
////            if(sameSuit && suitBonusActive) suitBonusActive = false;
//
////            //if(!sameSuit) suitBonusActive = false;
////            if(sameColour && !colourBonusActive) colourBonusActive = true;
////            if(sameColour && colourBonusActive) colourBonusActive = false;
//
////            if(suitBonusActive) streak = streak +2;
////            if(colourBonusActive) streak++;
//            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
//
//                maxStreak = streak;
//            }
//            //System.out.println("\nCurrent streak " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//            card1 = card2;
//        }
//        if(suitBonusActive) maxStreak = maxStreak + 2;//streak = streak+2;
//        if(colourBonusActive) maxStreak++;
//        hand.arrToStack(arr);
//        return maxStreak;
//    }

    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1;
        Card[] arr = hand.toArray();
        Card card1 = arr[0], card2;
        boolean suitBonusActive =false;
        boolean colourBonusActive = false;
        for(int i = 1; i < handSize; i++) {
            card2 = arr[i];
            if (card1.compareTo(card2) < 0) { // IF ADJACENT CARDS ARE +1 IN ORDER
                streak++;
                if(card1.getSuit().equals(card2.getSuit()) && !suitBonusActive){
                    suitBonusActive =true;
                }
                if(card1.getSuit().equals(card2.getSuit()) && suitBonusActive) suitBonusActive = false;
                if (!card1.getSuit().equals(card2.getSuit())) {
                    if(suitBonusActive) streak = streak-2;
                    suitBonusActive = false;
                }
                //System.out.println("Same suit bonus = " + sameSuit);
                if(card1.getColour().equals(card2.getColour())){
                    colourBonusActive = true;
                }
                if(card1.getColour().equals(card2.getColour()) && colourBonusActive) colourBonusActive = false;
                if (!card2.getColour().equals(card2.getColour())) {
                    if(colourBonusActive) streak--;
                    colourBonusActive = false;
                }
            }
            if (card1.compareTo(card2) > 0) { // IF CARDS ARE NOT +1 IN ORDER
                streak = 1;                   // reset counter for same colour/suit
                colourBonusActive = false;
                suitBonusActive = false;
            }
            if(suitBonusActive && card1.getSuit().equals(card2.getSuit())) streak = streak + 2;//streak = streak+2;
            if(colourBonusActive && card1.getColour().equals(card2.getColour())) streak++;
            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
                maxStreak = streak;
            }
            card1 = card2;
        }

        hand.arrToStack(arr);
        return maxStreak;
    }

//    private static int maxStreak(){ // streak is now working for consecutive cards, now just need to update score based on colour and suit
//        int handSize = hand.getCapacity(), maxStreak = 1, streak = 1, colourCount = 0, suitCount = 0;
//        Card[] arr = hand.toArray();
//        Card card1 = arr[0], card2;
//        boolean sameSuit = false;
//        boolean sameColour = false;
//        boolean suitBonusActive =false;
//        boolean colourBonusActive = false;
//        for(int i = 1; i < handSize; i++) {
//            card2 = arr[i];
//            if (card1.compareTo(card2) < 0) { // IF ADJACENT CARDS ARE +1 IN ORDER
//                streak++;
//                if(card1.getSuit().equals(card2.getSuit())){
//                    suitBonusActive =true;
//                    suitCount++;
//                    // System.out.println("\nSuit count " + suitCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                }
//                if (!card1.getSuit().equals(card2.getSuit())) {
//                    if(suitBonusActive) streak = streak-2;
//                    suitBonusActive = false;
//                    streak--;
//                }
//                //System.out.println("Same suit bonus = " + sameSuit);
//                if(card1.getColour().equals(card2.getColour())){
//                    colourBonusActive = true;
//                    colourCount++;
//                    //System.out.println("\nColour count " + colourCount + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//                }
//                if (!card2.getColour().equals(card2.getColour())) {
//                    if(colourBonusActive) streak--;
//                    colourBonusActive = false;
//                    //streak--;
//                }
//                //sameColour = card1.getColour().equals(card2.getColour());
//                //System.out.println("Same colour bonus = " + sameColour);
//            }
//            if (card1.compareTo(card2) > 0) { // IF CARDS ARE NOT +1 IN ORDER
//                streak = 1;                   // reset counter for same colour/suit
//                colourCount = 0;
//                suitCount = 0;
//                colourBonusActive = false;
//                suitBonusActive = false;
//            }
//
//            // int currStreak = streak; // temp variable to compare suit and colour count against
//            //if(colourCount == currStreak-1 && colourCount!= 0) streak = streak + 1;
//            // if(suitCount >= currStreak-1 && colourCount!= 0) streak = streak+2;
////            if(sameSuit && !suitBonusActive)  suitBonusActive = true;
////            if(sameSuit && suitBonusActive) suitBonusActive = false;
//
////            //if(!sameSuit) suitBonusActive = false;
////            if(sameColour && !colourBonusActive) colourBonusActive = true;
////            if(sameColour && colourBonusActive) colourBonusActive = false;
//
////            if(suitBonusActive) streak = streak +2;
////            if(colourBonusActive) streak++;
//
//            if(streak > maxStreak){ // if the current streak is greater than max streak, then update streak
//                maxStreak = streak;
//                if(suitBonusActive) maxStreak = maxStreak + 2;//streak = streak+2;
//                if(colourBonusActive) maxStreak++;
//            }
//            //System.out.println("\nCurrent streak " + streak + "        CARDS CHECKED ===== " + card1 + " AGAINST " + card2);
//            card1 = card2;
//        }
//
//        hand.arrToStack(arr);
//        return maxStreak;
//    }
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


        hand.stash(arr[39]);
        hand.stash(arr[40]);
        hand.stash(arr[42]);
        hand.stash(arr[48]);
        hand.stash(arr[36]);
        hand.stash(arr[37]);
       // hand.stash(arr[38]);
       /// hand.stash(arr[41]);

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
