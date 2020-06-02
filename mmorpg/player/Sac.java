package fr.mugiwara.mmorpg.player;

import fr.mugiwara.mmorpg.game.Objet;
import fr.mugiwara.mmorpg.misc.ContainerObjets;

/**
 * Class Sac
 * @author Enrick
 * @version 1.0
 */
public class Sac extends ContainerObjets  {

	
	public Sac() {
		
		
		max_size = 8;
		
	}
	
	/**
	 * Ajouter un objet dans le sac
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
	 * Retirer un objet du sac
	 * @param Objet
	 */
	@Override
	public boolean removeObjet(Objet o) {

		content.remove(o);
		used_size--;
		return true;
		
	}

	@Override
	public void afficher() {
		int i = 0;
		System.out.println("Votre sac (" + used_size + ") : ");
		for (Objet objet : content) {
			System.out.println(" - " + objet.getNom());
			i++;
		}
		
		if(i == 0)  System.out.println(" - Vide");
		
	}
	
	
	
	
}
