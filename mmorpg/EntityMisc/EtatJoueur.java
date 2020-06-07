package fr.mugiwara.mmorpg.EntityMisc;

public enum EtatJoueur {

	HEALTHY ("Bonne sant�"),
	SUPERFICIAL_INJURY ("Blessure superficielles"),
	SLIGHTLY_INJURED ("L�g�rement bless�"),
	INJURED ("Bless�"),
	SEVERLY_INJURED("Gravement bless�"),
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
