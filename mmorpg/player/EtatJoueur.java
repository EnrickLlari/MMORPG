package fr.mugiwara.mmorpg.player;

public enum EtatJoueur {

	HEALTHY ("Bonne santé"),
	SUPERFICIAL_INJURY ("Blessure superficielles"),
	SLIGHTLY_INJURED ("Légèrement blessé"),
	INJURED ("Blessé"),
	SEVERLY_INJURED("Gravement blessé"),
	UNCONSCIOUS ("Inconscient"),
	DEAD ("Mort");
	
	private String name = "";
	
	EtatJoueur(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
