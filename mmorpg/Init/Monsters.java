package fr.mugiwara.mmorpg.Init;

import fr.mugiwara.mmorpg.Mmorpg;
import fr.mugiwara.mmorpg.monster.Monster;

public class Monsters {

	
	public static void init_monsters() {
		
		Monster test1 = new Monster();
		Mmorpg.game.monsters.add(test1);
		Monster test2 = new Monster();
		Mmorpg.game.monsters.add(test2);
		Monster test3 = new Monster();
		Mmorpg.game.monsters.add(test3);
		Monster test4 = new Monster();
		Mmorpg.game.monsters.add(test4);
		
	}
	
}
