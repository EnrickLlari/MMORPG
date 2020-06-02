package fr.mugiwara.mmorpg.player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.mugiwara.mmorpg.Mmorpg;
import fr.mugiwara.mmorpg.misc.Degre;
import fr.mugiwara.mmorpg.misc.Entite;


/**
 * Class Joueur
 * @author Sanjeevan
 * @version 1.0
 *
 */
public class Joueur extends Entite{
	
	// VARIABLES
	protected Actions actions;
	protected Degre force;
	protected Degre adresse;
	protected Degre resistance;
	protected Capacites capacites;
	protected ObjetsEquipe equiped;
	protected Sac sac;
	protected EtatJoueur etat;
	
	/*
	 * Constructeur du joueur
	 */
	public Joueur(int pos) {
		
		System.out.println("Cr�er votre personnage : ( Vous avez 18 degr�s � d�penser )");
		Boolean created = false;
		Boolean display_name = false;
		
		while(!display_name) {
			display_name = display_create();			
			
		}
		
		while(!created) {
			created = create_perso();
			
			if(created) {
				this.position = pos;
				System.out.println("Votre personnage a bien �t� cr�e !");
			} else {
				System.out.println("Erreur, vous avez utilis� plus ou moins de 18 degr�.");
				
				System.out.println("Veuillez re rentrer les valeurs :");
			}
		}
		
		capacites = new Capacites();
		equiped = new ObjetsEquipe();
		sac = new Sac();
		
		etat = EtatJoueur.HEALTHY;
		
		 actions = new Actions(this);
		
	}
	
	/**
	 * Afficher les stats du joueur
	 */
	public void statsAfficher() {
		
		System.out.println("Vos caract�ristiques ");
		System.out.println(" - Initiative : " + force.getDegre());
		System.out.println(" - Attaque : " + adresse.getDegre());
		System.out.println(" - Esquive : " + resistance.getDegre());
		
	}
	
	/**
	 * Afficher l'�tat du joueur
	 */
	public void getHealth() {
		System.out.println(" ");
		System.out.println("Votre �tat : " + etat.toString());
		System.out.println(" ");
	}
	
	/**
	 * Afficher le menu du joueur
	 */
	public void getMenu() {
		
		equiped.afficher();
		sac.afficher();
		statsAfficher();
		capacites.afficher();
		getHealth();

		System.out.println("Vos points d'actions : " + actions.getPoints());
		System.out.println("Actions possibles :");
		System.out.println("1 - Se d�placer [2PA]   | 3 - Utiliser un objet [?PA]");
		System.out.println("2 - Attaquer [3PA]      | 4 - Ramasser/Jeter un objet [1PA]");
		System.out.println("5 - Ne rien faire et terminer votre tour");
		System.out.println(" ");
		getAction();

		
	}
	
	/**
	 * Proposer les actions � effectuer
	 */
	public void getAction() {
		
		List<String> resp_pos = Arrays.asList("1", "2", "3", "4", "5");
		

		boolean check = false;
		
		while(!check) {
			System.out.println("Que voulez vous faire ?");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String resp = sc.nextLine();
			if(resp_pos.contains(resp)) {
				check = true;
			}
		}
		
		// DO ACTION
	}
	
	/**
	 * D�finie le display name du joueur
	 * @return boolean
	 */
	public boolean display_create() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String display_nm = "";
		
		
		System.out.println("Entrez un nom pour votre personnage ( une lettre seulement ) :");
		if(sc.hasNext()) {
			display_nm = sc.nextLine();
		}
		
		if(display_nm.length() == 1) {
			this.display = display_nm.toUpperCase();
			
			return true;
		} else {
			return false;
		}
		
	}
	
	
	/**
	 * V�rifie lors de la cr�ation du perso, les x degre sont utilis�s.
	 * @return Boolean
	 */
	public boolean create_perso() {
		// Quantite de degre
		int deg_max = 18;
		
		int resp_force = 0;
		int resp_adresse = 0;
		int resp_resistance = 0;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Degr� de force :");
		if(sc.hasNext()) {
			resp_force = Integer.valueOf(sc.nextLine());
		}
		System.out.println("Degr� d'adresse :");
		if(sc.hasNext()) {
			resp_adresse = Integer.valueOf(sc.nextLine());
		}
		

		System.out.println("Degr� de r�sistance :");
		if(sc.hasNext()) {
			resp_resistance = Integer.valueOf(sc.nextLine());
		}
		
		
		if(Integer.valueOf(resp_force) + Integer.valueOf(resp_adresse) + Integer.valueOf(resp_resistance) != deg_max) {
			return false;
		}
		
		this.force = new Degre(Integer.valueOf(resp_force));
		this.adresse = new Degre(Integer.valueOf(resp_adresse));
		this.resistance = new Degre(Integer.valueOf(resp_resistance));
		
		
		return true;
		
	}
	
	
	/**
	 * Faire d�placer le joueur
	 * @param dir String
	 * @return Boolean
	 */
	public boolean deplacer(String dir) {
		int newPos = this.position;
		
		if(dir.equalsIgnoreCase("h")) {
			newPos = this.position - 27;
			if(!Mmorpg.map.ifPosFree(newPos)) return false;
		} else if(dir.equalsIgnoreCase("b")) {
			newPos = this.position + 27;
			if(!Mmorpg.map.ifPosFree(newPos)) return false;

		} else if(dir.equalsIgnoreCase("d")) {
			newPos = this.position +1;
			if(!Mmorpg.map.ifPosFree(newPos)) return false;

		} else if(dir.equalsIgnoreCase("g")) {
			newPos = this.position - 1;
			if(!Mmorpg.map.ifPosFree(newPos)) return false;
		} else {
			return false;
		}
		this.position = newPos;
		return true;
		
	}

}
