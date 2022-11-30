public class Player {

    private final String playerName;
    private int playerScore;

    public Player(String playerName, int playerScore){
        this.playerName = playerName;
        this.playerScore = playerScore;
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
}
