import java.util.Scanner;

public class House {

    private final Scanner scan = new Scanner(System.in);
    //this class will act as main class, house aka dealer.
    public static void main(String[] args){
        menu();
    }

    private static void menu(){
//        System.out.println("Please choose from the options available");
//        System.out.println("♠");
        Card[] myCards = new Card[52];
        int index = 0; //this method is working, it is creating 13 of each suit and putting it into an array
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                myCards[index] = new Card(rank, suit);
                index++;
            }
        }

        for (Card myCard : myCards) {
            System.out.println(myCard.toString());
        }
    }

}
