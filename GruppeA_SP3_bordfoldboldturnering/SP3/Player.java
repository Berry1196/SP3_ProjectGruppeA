package SP3;

public class Player {

    public String playerName;

    public Player(String playerName)  {
        this.playerName = playerName;
    }

    //is not used but can be used to get the player names to be displayed
    private String getPlayerName() {
        return this.playerName;
    }

    @Override
    public String toString() {
        return playerName;
    }
}

