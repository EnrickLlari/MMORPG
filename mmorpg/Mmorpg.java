package fr.mugiwara.mmorpg;

import java.util.ArrayList;
import java.util.Scanner;

import fr.mugiwara.mmorpg.game.Map;
import fr.mugiwara.mmorpg.game.Mur;
import fr.mugiwara.mmorpg.misc.Entite;
import fr.mugiwara.mmorpg.player.Joueur;

/**
 * Classe Mmorpg
 * @author Sanjeevan
 * @version 1.0
 *
 */
public class Mmorpg {
	
	public static Map map;
	
	/*
	 * Constructeur du joueur
	 */
	public Mmorpg() {
		
		System.out.println("Démarrage du jeu.");
		
		if(menu()) {
			Mmorpg.map = new Map();
		} else {
			// Charger une partie
		}
		
		Joueur player = new Joueur(192);
		map.addEntite(player);
		
		map.buildMap();
		
		player.getMenu();

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
	 * Affichier la map ( Entité avec sa position )
	 */
	public void afficher() {
		
		for(Entite ent : Mmorpg.map.getMap()) {
			
			System.out.println(ent.getDisplay() + " sur " +ent.getPosition());	
			
			System.out.println(ent.toString());
			
		}
		
	}
	
	/*
	 * Ajouter une entité à la map
	 */
	public void addtoMap(Entite e) {
		
		Mmorpg.map.addEntite(e);
		
	}
	
	
	
	
	/*
	 * Fonction de test
	 */
	public static void main(String[] args) {
		
		Mmorpg jeu = new Mmorpg();
		
		
		Mur.initialise_murs(Mmorpg.map);
		
		
		
	}
	
	
	
	
	
	

}
