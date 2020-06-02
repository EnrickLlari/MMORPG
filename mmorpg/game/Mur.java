package fr.mugiwara.mmorpg.game;

import fr.mugiwara.mmorpg.misc.Entite;

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
		
		int[] mur_pos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,34,53,54,61,80,81,88,107,101,108,128,134,135,146,147,148,149,150,153,154,155,156,157,158,159,160,161,162,175,188,189,202,215,216,229,242,243,247,256,269,270,274,283,296,297,298,299,300,301,302,303,310,323,324,350,351,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404};
		
		for(int i : mur_pos) {
			
			Mur mur = new Mur(i);
			
			map.addEntite(mur);
			
		}
		
	}
	

}
