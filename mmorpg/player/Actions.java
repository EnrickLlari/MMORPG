package fr.mugiwara.mmorpg.player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import fr.mugiwara.mmorpg.game.Decor;
import fr.mugiwara.mmorpg.misc.Objet;

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
	final int PRICE_PICK = 1;
	final int PRICE_THROW = 1;
	
	
	/**
	 * Constructeur des actions
	 * @param Joueur
	 */
	public Actions(Joueur j) {
		
		this.j = j;
		this.points = 300;
	
	}
	
	/**
	 * Retourne les points
	 * @return Integer
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Genération des points
	 */
	public void generatePoints() {
		
		int n_points = 2;
		
		n_points += j.capacites.getInitiative().getValue();
		
		j.actions.addPoints(n_points);
		
	}
	
	/**
	 * Ajouter des points d'actions
	 * @param int points
	 */
	public void addPoints(int pts) {
		this.points += pts;
	}

	/**
	 * Vérifie si il peut effectuer l'action
	 * @param String
	 * @return Boolean
	 */
	public boolean canAction(String act) {
		if(act.equalsIgnoreCase("move") && points >= PRICE_MOVE) {
			return true;
		} else if(act.equalsIgnoreCase("atk") && points >= PRICE_ATK) {
			return true;
		} else if(act.equalsIgnoreCase("pickup") && points >= PRICE_PICK) {
			return true;
		} else if(act.equalsIgnoreCase("throw") && points >= PRICE_THROW) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Vérifie si il peut effectuer l'action
	 * @param cost Int
	 * @return Boolean
	 */
	public boolean canAction(int cost) {
		
		if(points >= cost) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Damande d'attaque
	 */
	public void attack() {
		
		boolean check = false;
		
		if(!canAction("atk")) {
			System.out.println("Vous n'avez pas assez de points pour effectuer cette action.");
			return;
		}
		
		while(!check) {
			check = Attaquer();
		}
		
		
	}
	
	/**
	 * Faire attaquer une entité
	 * @return Boolean
	 */
	public boolean Attaquer() {
		
		String direction = getDirection();
		
		if(direction.equalsIgnoreCase("annuler")) {
			return true;
		}
		
		boolean attaque = j.attaquer(direction);

		if(attaque) {
			addPoints(-PRICE_ATK);
			j.experience.addExp(1);
		}
		
		return attaque;
		
	}
	
	public void objet_use() {
		
		boolean check = false;
		
		while(!check) {
			check = Utiliser();
		}
		
	}
	
	/**
	 * Faire Utiliser un objet
	 * @return Boolean
	 */
	public boolean Utiliser() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Objet obj_use = null;
		boolean use_item = false;
		boolean check = false;
		String id_objet;
		
		HashMap<Objet, Integer> j_sac = j.sac.getContent();
		HashMap<Objet, Integer> j_equiped = j.equiped.getContent();
		
		while(!check) {
			
			System.out.println("Entrez l'id de l'objet à utiliser ?");
			
			id_objet = sc.nextLine();
			
			if(id_objet.equalsIgnoreCase("annuler")) return true;
			
			if(id_objet.startsWith("-")) {
				
				id_objet.substring(1);
				
				for(Objet objet : j_equiped.keySet()) {
					
					if(j_equiped.get(objet) == Integer.valueOf(id_objet)) {
						check = true;
						obj_use = objet;
						use_item = false;
						break;
					}
					
				}
				
			} else {
				
				for(Objet objet : j_sac.keySet()) {
					
					if(j_sac.get(objet) == Integer.valueOf(id_objet)) {
						check = true;
						obj_use = objet;
						use_item = true;
						break;
					}
					
				}
				
			}
			

			
		}
		
		if(use_item) {
			
			j.sac.removeObjet(obj_use);
			j.equiped.addObjet(obj_use);
			addPoints(-obj_use.getCost());
		} else {
			j.equiped.removeObjet(obj_use);
			j.sac.addObjet(obj_use);
		}
		
		
		System.out.println("L'objet a bien été utilisé/équipé.");
		return true;
	}
	
	
	/**
	 * Demande de throw
	 */
	public void objet_throw() {
		
		boolean check = false;
		
		if(!canAction("throw")) {
			System.out.println("Vous n'avez pas assez de points pour effectuer cette action.");
			return;
		}
		
		while(!check) {
			
			check = Jeter();
		}
		
		
	}
	
	/**
	 * Faire jeter un objet
	 * @return Boolean
	 */
	public boolean Jeter() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Objet obj_throw = null;
		boolean check = false;
		String id_objet;
		
		HashMap<Objet, Integer> j_sac = j.sac.getContent();
		
		while(!check) {
			
			System.out.println("Entrez l'id de l'objet à jeter ?");
			
			id_objet = sc.nextLine();
			
			if(id_objet.equalsIgnoreCase("annuler")) return true;
			
			for(Objet objet : j_sac.keySet()) {
				
				if(j_sac.get(objet) == Integer.valueOf(id_objet)) {
					check = true;
					obj_throw = objet;
					break;
				}
				
			}
			
		}
		
		
		String direction = getDirection();
		
		if(direction.equalsIgnoreCase("annuler")) return true;
		
		int pos = j.getPosition();
		
		if(direction.equalsIgnoreCase("h")) {
			
			pos -= 27; 
			
		} else if(direction.equalsIgnoreCase("b")) {
			
			pos += 27;
			
		} else if(direction.equalsIgnoreCase("g")) {
			
			pos -= 1;
			
		} else if(direction.equalsIgnoreCase("d")) {
			
			pos += 1;
			
		}
		
		@SuppressWarnings("unused")
		Decor objet = new Decor(pos, obj_throw.getDisplay(), obj_throw);
		
		j.sac.removeObjet(obj_throw);
		System.out.println("L'objet a bien été déposé par terre.");
		addPoints(-PRICE_THROW);
		return true;
	}
	
	
	/**
	 * Damande de pickup
	 */
	public void pickup() {
		
		boolean check = false;
		
		if(!canAction("move")) {
			System.out.println("Vous n'avez pas assez de points pour effectuer cette action.");
			return;
		}
		
		while(!check) {
			check = Ramasser();
		}
		
		
	}
	
	/**
	 * Ramasser
	 * @return Boolean
	 */
	public boolean Ramasser() {
		
		String direction = getDirection();
		
		if(direction.equalsIgnoreCase("annuler")) {
			return true;
		}
		
		boolean ramassement = j.prendre(direction);

		if(ramassement) {
			addPoints(-PRICE_PICK);
		}
		
		return ramassement;
		
	}
	
	/**
	 * Demande de déplacement
	 */
	public void move() {
		
		boolean check = false;
		
		if(!canAction("move")) {
			System.out.println("Vous n'avez pas assez de points pour effectuer cette action.");
			return;
		}
				
		while(!check) {
			
			check = Bouger();
			
		}
		

	}
	
	/**
	 * Faire le déplacement
	 * @return Boolean
	 */
	public boolean Bouger() {
		
		String direction = getDirection();
		
		if(direction.equalsIgnoreCase("annuler")) {
			return true;
		}
		
		
		
		boolean deplacement = j.deplacer(direction);

		if(deplacement) {
			addPoints(-PRICE_MOVE);
		}
		
		return deplacement;
	}
	
	/**
	 * Dans quel direction effectuer l'action
	 * @return String
	 */
	public String getDirection() {
		
		System.out.println("Dans quel sens vous voulez faire l'action ? (H, B, G, D)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		List<String> dirs = Arrays.asList("h", "b", "g", "d", "H", "B", "G", "D");
		
		String direction = null;
		
		boolean check = false;
		
		while(!check) {
			
			 direction = sc.nextLine();
			 
			 if(direction.equalsIgnoreCase("annuler")) return "annuler";
			
			if(dirs.contains(direction)) {
				
				check = true;
			}
			
		}
		
		return direction;
		
	}
	

}
