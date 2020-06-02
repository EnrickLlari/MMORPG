package fr.mugiwara.mmorpg.game;

public enum GameState {
	
	WAITING ("En attente"),
	IN_PROGRESS("En cours"),
	COMPLETED("Terminé");
	
	
	private String name = "";
	
	GameState(String name) {
		this.name =name;
	}

	public String toString() {
		return name;
	}
	
}
