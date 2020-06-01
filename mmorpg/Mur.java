package fr.mugiwara.mmorpg;

/**
 * Class Mur
 * @author Sanjeevan
 * @version 1.0
 *
 */
public class Mur extends Entite{
	
	/**
	 * Constructeur du mur
	 * @param pos Integer
	 */
	public Mur(int pos) {
		this.position = pos;
		this.display = "#";
	}
	
	
	/**
	 * Ajouter tous les murs à la map du jeu
	 * @param map Map
	 */
	public static void initialise_murs(Map map) {
		
		int[] mur_pos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,34,53,54,61,80,81,88,107,108};
		
		for(int i : mur_pos) {
			
			Mur mur = new Mur(i);
			
			map.addEntite(mur);
			
		}
		
	}
	

}
