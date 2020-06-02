package fr.mugiwara.mmorpg.game;
/**
 * Class Objets
 * @author Enrick
 * @version 1.0
 */


public class Objet {
	private String nom;
	private String action;
	private int action_value;
	private int cost;
	

	
	public String getNom() {
		return nom;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getAction_value() {
		return action_value;
	}
	public void setAction_value(int action_value) {
		this.action_value = action_value;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
