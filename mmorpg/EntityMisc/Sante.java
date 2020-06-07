package fr.mugiwara.mmorpg.EntityMisc;

import java.util.HashMap;

import fr.mugiwara.mmorpg.misc.Entite;
import fr.mugiwara.mmorpg.player.Joueur;

/**
 * Class Sante
 * @author Sanjeevan
 * @version 1.0
 */
public class Sante {
	
	// VARIABLES 
	protected EtatJoueur etat;
	private Entite j;
	protected int etat_num;
	protected int etat_state;
	private HashMap<Integer, EtatJoueur> etats = new HashMap<>();
	
	/**
	 * Constructeur sans paramètres
	 */
	public Sante(Joueur j) {
		
		init_etats();
		this.j = j;
		etat = EtatJoueur.HEALTHY;
		etat_num = 0;
		etat_state = 3;
		
	}
	
	/**
	 * Constructeur avec paramètre
	 * @param healt Integer
	 */
	public Sante(int healt, Entite j) {
		init_etats();
		int snt = etats.size() - 1;
		this.j = j;
		while(healt > 0) {
			
			if(healt >= 3) {
				healt -= 3;
				snt--;
				
			} else {
				etat_state = healt;
				healt = 0;
			}

		}
		
		if(snt < 0) snt = 0;
		
		etat = etats.get(snt);
		etat_num = snt;
		
	}
	
	/**
	 * Getter EtatJoueur
	 * @return EtatJoueur
	 */
	public EtatJoueur getEtat() {
		return etat;
	}
	
	/**
	 * Récupérer l'état à i state
	 * @param i Integer
	 * @return EtatJoueur
	 */
	public EtatJoueur recupEtat(int i) {
		
		return etats.get(etat_num+i);
		
	}
	
	/**
	 * Setter etat à i state
	 * @param etat Integer
	 */
	public void setEtat(int etat) {
		this.etat = recupEtat(etat);
		etat_num += etat;
		etat_state = 3;
		
		
	}
	
	/**
	 * Faire subir des dégat
	 * @param degat Integer
	 */
	public void getDegat(int degat, Entite tueur) {
		
		while(degat > 0) {
			
			this.etat_state--;
			
			degat--;
			
			if(this.etat_state == 0) setEtat(1);
			if(etat.equals(EtatJoueur.DEAD)) break;
		}
	
		
		if(etat == EtatJoueur.DEAD) {
			
			j.mort(tueur);
			
		}
		
		
	}
	
	/**
	 * Initialiser le HashMap des etats
	 */
	public void init_etats() {
		
		int i = 0;
		
		for(EtatJoueur etat_jr : EtatJoueur.class.getEnumConstants()) {
			
			etats.put(i, etat_jr);
			
			i++;
			
		}
		
	}
	

}
