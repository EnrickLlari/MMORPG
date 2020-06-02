package fr.mugiwara.mmorpg.player;

import fr.mugiwara.mmorpg.game.Objet;
import fr.mugiwara.mmorpg.misc.ContainerObjets;

/**
 * Class ObjetEquipe
 * @author Enrick
 * @version 1.0
 */

public class ObjetsEquipe extends ContainerObjets{
	

	/**
	 * Constructeur des objets equipes
	 */
	public ObjetsEquipe() {
		max_size = 2;
	}
	
	
	/**
	 * Ajouter un objet à équiper
	 * @param Objet
	 */
	@Override
	public boolean addObjet(Objet o) {
		
		if(spaceFree()) {
			
			content.add(o);
			used_size++;
			
			return true;
		}
		return false;
		
	}

	/**
	 * Retirer un objet équipé
	 */
	@Override
	public boolean removeObjet(Objet o) {

		if(content.contains(o)) {
			content.remove(o);
			used_size--;
			return true;
		} else {
			return false;
		}

		
	}


	@Override
	public void afficher() {
		int i = 0;
		System.out.println("Objets équipés (" + used_size + ") : ");
		for (Objet objet : content) {
			System.out.println(" - " + objet.getNom());
			i++;
		}
		
		if(i == 0)  System.out.println(" - Vide");
		
	}
	
	
	
	
}
