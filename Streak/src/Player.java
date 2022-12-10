import java.util.Scanner;

public class Player implements Comparable<Player> {

    private final String playerName;
    private int playerScore;

    public Player(String playerName, int playerScore){
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public static Player createPlayer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name > ");
        return new Player(scan.nextLine(), 0);
    }

    public String toString(){
        return playerName + "   :    " + playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int compareTo(Player otherPlayer) {
        return Integer.compare(playerScore, otherPlayer.playerScore);
    }
}
