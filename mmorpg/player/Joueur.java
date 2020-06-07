package fr.mugiwara.mmorpg.player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.mugiwara.mmorpg.EntityMisc.Capacites;
import fr.mugiwara.mmorpg.EntityMisc.Sante;
import fr.mugiwara.mmorpg.game.Decor;
import fr.mugiwara.mmorpg.game.Game;
import fr.mugiwara.mmorpg.game.GameState;
import fr.mugiwara.mmorpg.misc.Degre;
import fr.mugiwara.mmorpg.misc.Entite;
import fr.mugiwara.mmorpg.monster.Monster;


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
	protected Sante sante;
	protected Experience experience;
	
	/*
	 * Constructeur du joueur
	 */
	public Joueur(int pos) {
		
		System.out.println("Créer votre personnage : ( Vous avez 18 degrés à dépenser )");
		Boolean created = false;
		Boolean display_name = false;
		
		while(!display_name) {
			display_name = display_create();			
			
		}
		
		while(!created) {
			created = create_perso();
			
			if(created) {
				this.position = pos;
				System.out.println("Votre personnage a bien été crée !");
			} else {
				System.out.println("Erreur, vous avez utilisé plus ou moins de 18 degré.");
				
				System.out.println("Veuillez re rentrer les valeurs :");
			}
		}
		
		capacites = new Capacites();
		equiped = new ObjetsEquipe(this);
		sac = new Sac();
		
		sante = new Sante(this);
		
		actions = new Actions(this);
		
		experience = new Experience(this);
		
	}
	
	/**
	 * Afficher les stats du joueur
	 */
	public void statsAfficher() {
		
		System.out.println("Vos caractéristiques ");
		System.out.println(" - Force : " + force.getDegre());
		System.out.println(" - Adresse : " + adresse.getDegre());
		System.out.println(" - Résistance : " + resistance.getDegre());
		
	}
	
	/**
	 * Getter Santé
	 * @return Sante
	 */
	public Sante getSante() {
		return sante;
	}
	
	/**
	 * Getter Capacités
	 * @return Capacites
	 */
	public Capacites getCapacites() {
		return capacites;
	}
	
	/**
	 * Retourne actions
	 * @return Action
	 */
	public Actions getAct() {
		return actions;
	}
	
	/**
	 * Getter experience
	 */
	public Experience getExperience() {
		return experience;
	}
	
	/**
	 * Afficher l'état du joueur
	 */
	public void getHealth() {
		System.out.println(" ");
		System.out.println("Votre état : " + sante.getEtat().toString());
		System.out.println("Niveau du personnage : " + experience.getNiv() + " (" + experience.getExp() + "/" + experience.getNextLevelExp() + ")");
	}
	
	/**
	 * Afficher le menu du joueur
	 */
	public boolean getMenu() {
		Game.StateAfficher();
		Game.map.buildMap();
		equiped.afficher();
		sac.afficher();
		statsAfficher();
		capacites.afficher();
		getHealth();

		System.out.println("Vos points d'actions : " + actions.getPoints());
		System.out.println("Actions possibles :");
		System.out.println("1 - Se déplacer [2PA]       | 2 - Attaquer [3PA]");
		System.out.println("3 - Utiliser un objet [?PA] | 4 - Ramasser un objet [1PA]");
		System.out.println("5 - Jeter un objet [1PA]    | 6 - Terminer le tour");
		System.out.println(" ");
		Boolean act = getAction();

		return act;
	}
	
	/**
	 * Proposer les actions à effectuer
	 */
	public boolean getAction() {
		
		List<String> resp_pos = Arrays.asList("1", "2", "3", "4", "5", "6");
		

		boolean check = false;
		String resp = "";
		while(!check) {
			System.out.println("Que voulez vous faire ?");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			resp = sc.nextLine();
			if(resp_pos.contains(resp)) {
				check = true;
			}
		}
		
		// DO ACTION
		if(resp.equals("6")) {
			return true;
		} else if(resp.equals("1")) {
			actions.move();
		} else if(resp.equals("2")) {
			actions.attack();
		} else if(resp.equals("3")) {
			actions.objet_use();
		} else if(resp.equals("4")) {
			actions.pickup();
		} else if(resp.equals("5")) {
			actions.objet_throw();
		}
		
		return false;
		
	}
	
	/**
	 * Définie le display name du joueur
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
	 * Vérifie lors de la création du perso, les x degre sont utilisés.
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
		
		
		
		System.out.println("Degré de force :");
		if(sc.hasNext()) {
			resp_force = Integer.valueOf(sc.nextLine());
		}
		System.out.println("Degré d'adresse :");
		if(sc.hasNext()) {
			resp_adresse = Integer.valueOf(sc.nextLine());
		}
		

		System.out.println("Degré de résistance :");
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
	 * Faire ramasser un objet
	 * @param direction String
	 * @return Boolean
	 */
	public boolean prendre(String direction) {
		
		int pos = getPositionNear(this.position, direction);
		
		if(Game.map.isObjet(pos)) {
			Decor dec = (Decor) Game.map.getEntite(pos);
			sac.addObjet(dec.getObjet());
			Game.map.removeEntite(pos);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Faire attaquer l'entité
	 * @param direction String
	 * @return Boolean
	 */
	public boolean attaquer(String direction) {
		
		int pos = getPositionNear(this.position, direction);
		if(Game.map.getEntite(pos) instanceof Monster) {
			
			Monster mob = (Monster) Game.map.getEntite(pos);

			int atk_score = capacites.getAttaque().getValue();
			int esquive_score = mob.getCapacites().getEsquive().getValue();
			int force_score = force.getValue();

			
			if(esquive_score >= atk_score + force_score) {
				System.out.println("Le monstre a esquivé votre attaque !");
				return true;
			}
			
			int defense_score = mob.getCapacites().getDefense().getValue();
			
			if(defense_score >= atk_score + force_score) {
				System.out.println("Votre attaque ne semble avoir fait aucun dégât.");
				return true;
			}
			
			int degat = ((atk_score + force_score) - defense_score) + capacites.getDegat().getValue();
			mob.getSante().getDegat(degat, this);
			System.out.println("Vous avez attaqué ! ( Dégât infligé : " + degat + ")");
			
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * Récupére la position en fonction de la direction
	 * @param dir String
	 * @return Integer
	 */
	public static int getPositionNear(int pos, String dir) {
		
		
		if(dir.equalsIgnoreCase("h")) {
			
			pos -= 27; 
			
		} else if(dir.equalsIgnoreCase("b")) {
			
			pos += 27;
			
		} else if(dir.equalsIgnoreCase("g")) {
			
			pos -= 1;
			
		} else if(dir.equalsIgnoreCase("d")) {
			
			pos += 1;
			
		}
		
		return pos;
		
	}
	

	/**
	 * Vérifier si c'est un objet
	 * @param pos Interger
	 * @return Boolean
	 */
	public boolean isObjet(int pos) {
		
		
		return false;
	}
	
	@Override
	public void mortaction() {
		Game.setState(GameState.COMPLETED);
		
		System.out.println(" ");
		System.out.println("  >>> Vous êtes mort ! <<<");
		System.out.println("     Fin de la partie.");
		System.out.println(" ");
	}
	
}
