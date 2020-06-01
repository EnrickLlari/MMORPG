package fr.mugiwara.mmorpg;

import java.util.ArrayList;

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
	}
	
	/**
	 * Retourne la map
	 * @return ArrayList<Entite>
	 */
	public ArrayList<Entite> getMap() {
		return this.game_map;
	}

	/**
	 * Ajouter une entité à la map
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
			
			if(e.getPosition() == pos) {
				return true;
			}
			
		}
		
		return false;
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
