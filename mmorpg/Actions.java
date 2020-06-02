package fr.mugiwara.mmorpg;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class Actions
 * @author Sanjeevan
 * @version 1.0
 */
public class Actions {

	/**
	 * Demande de déplacement
	 * @param j Joueur
	 */
	public static void move(Joueur j) {
		
		boolean check = false;
				
		while(!check) {
			
			check = Bouger(j);
			
		}
		
	}
	
	/**
	 * Faire le déplacement
	 * @param j Joueur
	 * @return Boolean
	 */
	public static boolean Bouger(Joueur j) {
		
		
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
