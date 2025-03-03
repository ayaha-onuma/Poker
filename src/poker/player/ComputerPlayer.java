package poker.player;

public class ComputerPlayer extends Player {

	private String[] names = { "player1", "player2", "player3", "player4", "player5" };

	public ComputerPlayer(int i) {
		name = names[i];
	}

}
