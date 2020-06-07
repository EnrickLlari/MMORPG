package fr.mugiwara.mmorpg.game;

/**
 * Class GameState
 * @author Sanjeevan
 * @version 1.0
 */
public enum GameState {
	// VARIABLES POSSIBLES
	WAITING ("En attente"),
	IN_PROGRESS("En cours"),
	COMPLETED("Terminé");
	
	
	private String name = "";
	
	/**
	 * Constructeur
	 * @param name
	 */
	GameState(String name) {
		this.name =name;
	}

	/**
	 * Getter name
	 */
	public String toString() {
		return name;
	}
	
}
