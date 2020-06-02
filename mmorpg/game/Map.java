package fr.mugiwara.mmorpg.game;

import java.util.ArrayList;

import fr.mugiwara.mmorpg.misc.Entite;

/**
 * Class Map
 * @author Sanjeevan
 * @version 1.0
 */
public class Map {
	
	private ArrayList<Entite> game_map;
	
	/*
	 * Constructeur de la Map
	 */
	public Map() {
		this.game_map = new ArrayList<Entite>();
		
		Mur.initialise_murs(this);
	}
	
	/**
	 * Retourne la map
	 * @return ArrayList<Entite>
	 */
	public ArrayList<Entite> getMap() {
		return this.game_map;
	}

	/**
	 * Ajouter une entit� � la map
	 * @param Entite
	 */
	public void addEntite(Entite e) {
		game_map.add(e);
	}
	
	/**
	 * Permet de voir si une posistion est libre ou pas
	 * @param pos Integer
	 * @return Boolean 
	 */
	public boolean ifPosFree(int pos) {
		
		for(Entite e : game_map) {
			
			if(pos == e.getPosition()) {
				
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * Affiche la map
	 */
	public void buildMap() {
		
		int i = 0;
		
		int line = 0;
		
		while(line < 15) {
			String line_str = "";
			
			for (int col = 0; col < 27; col++) {
				String dpn = " ";
				for(Entite e : game_map) {
					
					if(e.getPosition() == i) {
						dpn = e.getDisplay();
						break;
					}
					
					
				}
				
				line_str += dpn;
				i++;
				
			}
			
			System.out.println(line_str);
			
			line++;

		}
		
	}

}
