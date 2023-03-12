public class Battaile {

    private final Deck<Card> deck = new Deck<>();
    private final Replay<Card> sarah = new Replay<>();
    private final Replay<Card> jack = new Replay<>();
    public void setUp(){
        deck.fill();
        deck.shuffle();
        for(int i = 0; i<26; i++){
            sarah.enqueue(deck.deal());
        }
        for(int k = 0; k<26; k++){
            jack.enqueue(deck.deal());
        }
        play();
    }


    public void play(){
//        System.out.println("Time to play Bataille!");
//        int i = 0;
//        System.out.println("Sarah's hand.");
////        sarah.display();
//        System.out.println("------------------------");
//        System.out.println("Jack's hand.");
//        jack.display();
        int i = 0;
        while(i < 1){
            Card sarahsCard = sarahPlay();
            Card jacksCard = jackPlay();

            System.out.println(sarahsCard + " Sarah's card");
            System.out.println(jacksCard + " Jack's card");

            if(jacksCard.getRankValue() > sarahsCard.getRankValue()){
                System.out.println("JACK WINS!");
                jack.enqueue(jacksCard);
                jack.enqueue(sarahsCard);
            }else if(jacksCard.getRankValue() == sarahsCard.getRankValue()){
                System.out.println("IT'S A DRAW");
                
            }else{
                System.out.println("SARAH WINS!");
                sarah.enqueue(jacksCard);
                sarah.enqueue(sarahsCard);
            }
            i++;
        }
//        System.out.println("Sarah's hand.");
//        sarah.display();
//        System.out.println("------------------------");
//        System.out.println("Jack's hand.");
//        jack.display();
    }

    private Card sarahPlay(){
        return sarah.dequeue();
    }

    private Card jackPlay(){
        return jack.dequeue();
    }

}
