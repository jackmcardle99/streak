import java.util.Random;

public class Battaile {

    private final Deck<Card> deck = new Deck<>();

    private final Deck<Card> monke = new Deck<>();
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
          monke.fill();
          monke.display();
          //monke.clear();
          if(monke.isEmpty()){
              System.out.println("Monke is empty!");
          }
//        System.out.println("Time to play Bataille!");
//        int i = 0;
//        System.out.println("Sarah's hand.");
////        sarah.display();
//        System.out.println("------------------------");
////        System.out.println("Jack's hand.");
////        jack.display();
//        while(!sarah.isEmpty() || !jack.isEmpty()){
//            Card sarahsCard = sarah.dequeue();
//            Card jacksCard = jack.dequeue();
//
//            System.out.println(sarahsCard + " Sarah's card");
//            System.out.println(jacksCard + " Jack's card");
//
//            if(jacksCard.getRankValue() > sarahsCard.getRankValue()){
//                System.out.println("JACK TAKES THE CARDS!");
//                jack.enqueue(jacksCard);
//                jack.enqueue(sarahsCard);
//            }
//            else if(jacksCard.getRankValue() == sarahsCard.getRankValue()){
//                System.out.println("IT'S A DRAW");
//                sarah.enqueue(sarahsCard);
//                jack.enqueue(jacksCard);
//            }
//            else{
//                System.out.println("SARAH TAKES THE CARDS!");
//                sarah.enqueue(jacksCard);
//                sarah.enqueue(sarahsCard);
//            }
//        }
//        if(jack.isEmpty()){
//            System.out.println("Sarah wins! ----------------------");
//        }
//        if(sarah.isEmpty()){
//            System.out.println("Jack wins! ----------------------");
//        }

    }

    private void playDraw(Card jacksOrig, Card sarahsOrig){
        Card sCard1 = sarah.dequeue();
        Card sCard2 = sarah.dequeue();
        Card jCard1 = jack.dequeue();
        Card jCard2 = jack.dequeue();
        if(sCard2.getRankValue() > jCard2.getRankValue()){
            sarah.enqueue(sCard1);
            sarah.enqueue(sCard2);
            sarah.enqueue(jCard1);
            sarah.enqueue(jCard2);
            sarah.enqueue(sarahsOrig);
            sarah.enqueue(jacksOrig);
        } else if (jCard2.getRankValue() == sCard2.getRankValue()) {
            Random ran = new Random();
            int ranNum = ran.nextInt(0,2);
            if(ranNum ==1){
                jack.enqueue(sCard1);
                jack.enqueue(sCard2);
                jack.enqueue(jCard1);
                jack.enqueue(jCard2);
                jack.enqueue(sarahsOrig);
                jack.enqueue(jacksOrig);
            }else{
                sarah.enqueue(sCard1);
                sarah.enqueue(sCard2);
                sarah.enqueue(jCard1);
                sarah.enqueue(jCard2);
                sarah.enqueue(sarahsOrig);
                sarah.enqueue(jacksOrig);
            }
        }else {
            jack.enqueue(sCard1);
            jack.enqueue(sCard2);
            jack.enqueue(jCard1);
            jack.enqueue(jCard2);
            jack.enqueue(sarahsOrig);
            jack.enqueue(jacksOrig);
        }
    }

//    private Card sarahPlay(){
//        return sarah.dequeue();
//    }
//
//    private Card jackPlay(){
//        return jack.dequeue();
//    }

}
