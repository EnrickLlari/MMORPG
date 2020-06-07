package fr.mugiwara.mmorpg.player;

import fr.mugiwara.mmorpg.misc.ContainerObjets;
import fr.mugiwara.mmorpg.misc.Objet;

/**
 * Class ObjetEquipe
 * @author Enrick
 * @version 1.0
 */

public class ObjetsEquipe extends ContainerObjets{
	
	private Joueur j;

	/**
	 * Constructeur des objets equipes
	 */
	public ObjetsEquipe(Joueur j) {
		max_size = 2;
		this.j = j;
	}
	
	
	/**
	 * Ajouter un objet à équiper
	 * @param Objet
	 */
	@Override
	public boolean addObjet(Objet o) {
		
		if(!j.actions.canAction(o.getCost())) return false;
		
		if(spaceFree()) {
			
			content.put(o, used_size);
			used_size++;
			
			if(o.getCapacite().equalsIgnoreCase("initiative")) {
				
				j.capacites.addInitiative(o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("attaque")) {
				
				j.capacites.addAttaque(o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("esquive")) {
				
				j.capacites.addEsquive(o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("defense")) {
				
				j.capacites.addDefense(o.getCapacite_value());
				
			}  else if(o.getCapacite().equalsIgnoreCase("degat")) {
				
				j.capacites.addDegat(o.getCapacite_value());
				
			}
			
			j.actions.addPoints(-o.getCost());
			
			return true;
		}
		return false;
		
	}

	/**
	 * Retirer un objet équipé
	 */
	@Override
	public boolean removeObjet(Objet o) {

		
		if(content.containsKey(o)) {
			content.remove(o);
			used_size--;
			
			if(o.getCapacite().equalsIgnoreCase("initiative")) {
				
				j.capacites.addInitiative(-o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("attaque")) {
				
				j.capacites.addAttaque(-o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("esquive")) {
				
				j.capacites.addEsquive(-o.getCapacite_value());
				
			} else if(o.getCapacite().equalsIgnoreCase("defense")) {
				
				j.capacites.addDefense(-o.getCapacite_value());
				
			}  else if(o.getCapacite().equalsIgnoreCase("degat")) {
				
				j.capacites.addDegat(-o.getCapacite_value());
				
			}
			
			return true;
		} else {
			return false;
		}

		
	}


	/**
	 * Afficher les objets équipés
	 */
	@Override
	public void afficher() {
		int i = 0;
		System.out.println("Objets équipés (" + used_size + ") : ");
		for (Objet objet : content.keySet()) {
			System.out.println(" - " + objet.getNom() + " ["+ content.get(objet) + "]");
			i++;
		}
		
		if(i == 0)  System.out.println(" - Vide");
		
	}
	
	
	
	
}
