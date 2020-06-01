package fr.mugiwara.mmorpg;

import java.util.Scanner;
/**
 * Class ContainerObjets
 * @author Enrick
 * @version 1.0
 *
 */

public class ContainerObjets {
	

	
	/*
	 * Méthode d'ajout d'un objet
	 * par scanner
	 * @return Boolean
	 */
	public static boolean addObjet() {
		
		new Objets();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ramasser l'objet ? ");
		System.out.println("1- Oui ");
		System.out.println("2- Non ");
		
		String str = sc.nextLine();
		
		sc.close();
		if(str == "1") {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	/*
	 * Méthode de pour retirer un objet
	 * par scanner
	 */
	public static boolean removeObjet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Jeter l'objet ? ");
		System.out.println("1- Oui ");
		System.out.println("2- Non ");
		
		String str = sc.nextLine();
		
		sc.close();
		System.out.println(str);
		if(str == "1") {
			return true;
		}	
		
		else {
			return false;
		}
		
	}

}
