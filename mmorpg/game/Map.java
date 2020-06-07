package fr.mugiwara.mmorpg.game;

import java.util.ArrayList;
import java.util.Iterator;

import fr.mugiwara.mmorpg.Init.Walls;
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
		
		Walls.initialise_murs(this);
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
			
			if(pos == e.getPosition()) {
				
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * Vérifie si l'entité à la pos est un objet
	 * @param pos Integer
	 * @return Boolean
	 */
	public boolean isObjet(int pos) {
		
		for(Entite e : game_map) {
			
			if(pos == e.getPosition()) {
				
				if(e instanceof Decor) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Retourne l'entité à la position
	 * @param pos Int
	 * @return Entite
	 */
	public Entite getEntite(int pos) {
		
		for(Entite e : game_map) {
			
			if(pos == e.getPosition()) {
				return e;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Retirer une entité de la map
	 * @param pos Integer
	 */
	public void removeEntite(int pos) {
		
		Iterator<Entite> iter = game_map.iterator();
		
		while(iter.hasNext()) {
			
			Entite e = iter.next();
			
			if(pos == e.getPosition()) {
				
				iter.remove();
				
			}
			
		}
		
		
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
