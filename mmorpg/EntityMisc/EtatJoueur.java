package fr.mugiwara.mmorpg.EntityMisc;

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
