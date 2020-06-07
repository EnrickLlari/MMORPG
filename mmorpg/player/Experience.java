package fr.mugiwara.mmorpg.player;

import java.util.HashMap;

import fr.mugiwara.mmorpg.misc.Objet;

/**
 * Class Experience
 * @author Sanjeevan
 * @version 1.0
 */
public class Experience {
	
	// VARIABLES
	private Joueur j;
	private int niv;
	private int exp;
	private int calcul_next = (niv + 1) * (niv+1) + 2;
	private HashMap<Integer, String> recompenses;
	
	/**
	 * Constructeur expérience
	 * @param Joueur j
	 */
	public Experience(Joueur j) {
		this.j = j;
		niv = 0;
		exp = 0;
		initRecompenses();
	}
	
	/**
	 * Récupérer l'éxpérience nécessaire pour le niveau suivant
	 * @return Integer
	 */
	public int getExpToNextLvl() {
		int next = calcul_next - exp;
		return next;
		
	}
	
	/**
	 * Récupérer l'exp pour level up
	 * @return Integer
	 */
	public int getNextLevelExp() {
		return calcul_next;
	}
	
	/**
	 * Ajouter de l'expérience
	 * @param exp Integer
	 */
	public void addExp(int exp) {
		
		
		boolean check = false;
		
		while(!check) {
			int tonext_niv = calcul_next - this.exp;
			
			if(exp >= tonext_niv) {
				
				exp -= tonext_niv;
				niv++;
				this.exp = 0;
				onNivChange();
				
				
			} else {
				
				this.exp += exp;
				check = true;
				
			}
			
		}
		
		 
		
	}
	
	/**
	 * Initialiser les récompenses par niv
	 */
	public void initRecompenses() {
		
		recompenses = new HashMap<>();
		
		recompenses.put(1, "Objet,L'épée de samira,S,initiative,1,1;");
		recompenses.put(2, "Capacite,Defense,1;");
		
	}
	
	/**
	 * Vérification au changement de niveau
	 */
	public void onNivChange() {
		
		for(Integer niv : recompenses.keySet()) {
			
			if(this.niv == niv) {
				
				StringToGift(recompenses.get(niv));
				break;
			}
			
		}
		
	}
	
	/**
	 * Récupérer la récompenses avec un string
	 * @param String gift
	 */
	public void StringToGift(String gift) {
		String[] gifts = gift.split(";");
		
		for(String gift_once : gifts) {
			
			String[] gi = gift_once.split(",");
			
			if(gi[0].equalsIgnoreCase("Objet")) {
				
				Objet objet = new Objet(gi[1], gi[2], gi[3], Integer.valueOf(gi[4]), Integer.valueOf(gi[5]));
				
				j.sac.addObjet(objet);
				
			} else if (gi[0].equalsIgnoreCase("Capacite")) {
				
				String capa = gi[1];
				
				int capa_val = Integer.valueOf(gi[2]);
				
				if(capa.equalsIgnoreCase("Initiative")) {
					j.getCapacites().addInitiative(capa_val);
				} else if (capa.equalsIgnoreCase("Attaque")) {
					j.getCapacites().addAttaque(capa_val);
				} else if (capa.equalsIgnoreCase("Degat")) {
					j.getCapacites().addDegat(capa_val);
				} else if (capa.equalsIgnoreCase("Defense")) {
					j.getCapacites().addDefense(capa_val);
				} else if (capa.equalsIgnoreCase("Esquive")) {
					j.getCapacites().addEsquive(capa_val);
				} else if (capa.equalsIgnoreCase("Force")) {
					j.force.addDegre(capa_val);
				} else if (capa.equalsIgnoreCase("Resistance")) {
					j.resistance.addDegre(capa_val);
				} else if (capa.equalsIgnoreCase("Adresse")) {
					j.adresse.addDegre(capa_val);
				}
				
				
				
			}
			
		}
		
		
	}
	
	/**
	 * Getter exp
	 * @return int
	 */
	public int getExp() {
		return exp;
	}
	
	/**
	 * Getter niv
	 * @return int
	 */
	public int getNiv() {
		return niv;
	}

}
