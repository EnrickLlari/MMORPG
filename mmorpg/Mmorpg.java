package fr.mugiwara.mmorpg;

import java.util.ArrayList;
import java.util.Scanner;

import fr.mugiwara.mmorpg.game.Game;

/**
 * Class Mmorpg
 * @author Sanjeevan
 * @version 1.0
 *
 */
public class Mmorpg {
	
	public static Game game;
	/*
	 * Constructeur du joueur
	 */
	public Mmorpg() {
		
		System.out.println("Démarrage du jeu.");
		
		if(menu()) {
			Mmorpg.game = new Game();
		} else {
			// Charger une partie
		}


	}
	
	/**
	 * Menu principal du jeu
	 * @return Boolean
	 */
	public boolean menu() {
		
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("Que voulez vous faire :");
		msg.add("   - 1 : Créer une nouvelle partie");
		msg.add("   - 2 : Rejoindre une partie");
		msg.add("  ");
		
		
		for(String str : msg) {
			System.out.println(str);
		}
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Votre choix :");
		String resp = sc.nextLine();

		
		if(resp == "2") {
			return false;
		} else {
			return true;
		}
		
		
	}

	
	
	
	
	/*
	 * Fonction de test
	 */
	public static void main(String[] args) {
		
		Mmorpg jeu = new Mmorpg();
		
		
		
	}
	
	
	
	
	
	

}
