package fr.mugiwara.mmorpg.player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class Actions
 * @author Sanjeevan
 * @version 1.0
 */
public class Actions {
	
	// Player info
	private Joueur j;
	private int points;
	
	// Actions info
	final int PRICE_MOVE = 2;
	final int PRICE_ATK = 3;
	
	/**
	 * Constructeur des actions
	 * @param Joueur
	 */
	public Actions(Joueur j) {
		
		this.j = j;
	
	}
	
	/**
	 * Retourne les points
	 * @return Integer
	 */
	public int getPoints() {
		return points;
	}

	public boolean canAction(String act) {
		if(act.equalsIgnoreCase("move") && points >= PRICE_MOVE) {
			return true;
		} else if(act.equalsIgnoreCase("atk") && points >= PRICE_ATK) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Demande de déplacement
	 */
	public void move() {
		
		boolean check = false;
				
		while(!check) {
			
			check = Bouger();
			
		}
		
	}
	
	/**
	 * Faire le déplacement
	 * @return Boolean
	 */
	public boolean Bouger() {
		
		
		System.out.println("Dans quel sens vous voulez vous déplacer ? (H, B, G, D)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		List<String> dirs = Arrays.asList("h", "b", "g", "d", "H", "B", "G", "D");
		
		String direction = null;
		
		boolean check = false;
		
		while(!check) {
			
			 direction = sc.nextLine();
			 
			 if(direction.equalsIgnoreCase("annuler")) return true;
			
			if(dirs.contains(direction)) {
				
				check = true;
			}
			
		}
		
		
		return j.deplacer(direction);
		
	}
	

}
