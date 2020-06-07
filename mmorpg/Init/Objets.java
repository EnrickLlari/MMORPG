package fr.mugiwara.mmorpg.Init;

import fr.mugiwara.mmorpg.game.Decor;
import fr.mugiwara.mmorpg.misc.Objet;

public class Objets {
	
	@SuppressWarnings("unused")
	public static void init_objets() {
		
		Decor dec1 = new Decor(193, "K", new Objet("Katana", "K", "initiative", 2, 2));
		
		
		Decor dec2 = new Decor(210, "O", new Objet("Epée de feu", "E", "degat", 2, 2));
		
		
	}

}
