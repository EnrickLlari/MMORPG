package fr.mugiwara.mmorpg.monster;

import java.util.Random;

import fr.mugiwara.mmorpg.EntityMisc.Capacites;
import fr.mugiwara.mmorpg.EntityMisc.Sante;
import fr.mugiwara.mmorpg.game.Game;
import fr.mugiwara.mmorpg.misc.Entite;
import fr.mugiwara.mmorpg.player.Joueur;

/**
 * Class Monster
 * @author Sanjeevan
 * @version 1.0
 */
public class Monster extends Entite{
	
	protected Sante sante;
	protected Capacites capacites;
	
	/**
	 * Constructeur de Monster
	 */
	public Monster() {
		
		display = "M";
		
		boolean pos_check = false;
		
		while(!pos_check) {
			int pos = getRandomPos();
			
			pos_check = Game.map.ifPosFree(pos);
			if(pos_check) position = pos;
			
		}
		
		Game.map.addEntite(this);
		
		sante = new Sante(10, this);
		capacites = new Capacites();
		
		capacites.addAttaque(2);
		
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
	 * Générer une position aléatoire
	 * @return
	 */
	public int getRandomPos() {
		
		Random random = new Random();

		int col = random.nextInt(19 - 6) + 6;
		int lig = random.nextInt(12) + 2;
		
		return col * lig;
		
	}
	
	
	/**
	 * Récupérer la position d'un joueur à proximité
	 * @return Integer
	 */
	public int getNearPlayer() {
		
		// A un bloc
		int pos_h_1 = position - 27;
		int pos_b_1 = position + 27;
		int pos_g_1 = position - 1;
		int pos_d_1 = position + 1;
		
		// A deux blocs
		int pos_h_2 = position - (27 * 2);
		int pos_b_2 = position + (27 * 2);
		int pos_g_2 = position - 2;
		int pos_d_2 = position + 2;
		
		if(Game.map.getEntite(pos_h_1) instanceof Joueur || Game.map.getEntite(pos_b_1) instanceof Joueur || Game.map.getEntite(pos_g_1) instanceof Joueur || Game.map.getEntite(pos_d_1) instanceof Joueur) {
			return position;
		} else if(Game.map.getEntite(pos_h_2) instanceof Joueur) {
			return pos_h_2 + 27;
		} else if(Game.map.getEntite(pos_b_2) instanceof Joueur) {
			return pos_b_2 - 27;
		} else if(Game.map.getEntite(pos_g_2) instanceof Joueur) {
			return pos_g_2 + 1;
		} else if(Game.map.getEntite(pos_d_2) instanceof Joueur) {
			return pos_d_2 - 1;
		}
		
		return 0;
		
	}
	
	/**
	 * Faire un déplacement aléatoire
	 */
	public void moveAleatoire() {
		

		boolean check = false;
		while(!check) {
			
			String[] moves = {"h", "b", "g", "d"};
			
			int rand = (int) (Math.random() * 3);
			
			String move = moves[rand];
			
			check = this.deplacer(move);
		}
		
	}
	
	/**
	 * Effecture un tour avec le monstre
	 * @return
	 */
	public boolean tour() {
		
		int near_player = getNearPlayer();
		
		if(near_player == 0) {
			
			moveAleatoire();
			
			moveAleatoire();
			
		} else {
			
			
			int bloc_2h = position - (27);
			int bloc_2b = position + (27);
			int bloc_2g = position - 1;
			int bloc_2d = position + 1;
			
			if(near_player == position) {
				Boolean check = false;

				check = mobAttack("h");
				if(!check) {
					check = mobAttack("b");
				}
				if(!check) {
					check = mobAttack("g");
				}
				if(!check) {
					check = mobAttack("d");
				}
				
				Boolean check2 = false;

				check2 = mobAttack("h");
				if(!check2) {
					check2 = mobAttack("b");
				}
				if(!check2) {
					check2 = mobAttack("g");
				}
				if(!check2) {
					check2 = mobAttack("d");
				}
				
			} else if(near_player == bloc_2h) {
				System.out.println("Le monstre s'est déplacé près de vous !");
				deplacer("h");
				
				mobAttack("h");
				
			} else if(near_player == bloc_2b) {
				System.out.println("Le monstre s'est déplacé près de vous !");
				deplacer("b");

				mobAttack("b");
				
			} else if(near_player == bloc_2g) {
				System.out.println("Le monstre s'est déplacé près de vous !");
				deplacer("g");
				
				mobAttack("g");
				
			} else if(near_player == bloc_2d) {
				System.out.println("Le monstre s'est déplacé près de vous !");
				deplacer("d");
				
				mobAttack("d");
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean mobAttack(String direction) {
		
		int pos = Joueur.getPositionNear(position, direction);
		if(Game.map.getEntite(pos) instanceof Joueur) {
			
			Joueur joueur = (Joueur) Game.map.getEntite(pos);

			int atk_score = capacites.getAttaque().getValue();
			int esquive_score = joueur.getCapacites().getEsquive().getValue();

			
			if(esquive_score >= atk_score) {
				System.out.println("Vous avez esquivé l'attaque du monstre.");
				return true;
			}
			
			int defense_score = joueur.getCapacites().getDefense().getValue();
			
			if(defense_score >= atk_score) {
				System.out.println("L'attaque du monstre n'a fait aucun dégât.");
				return true;
			}
			
			int degat = ((atk_score) - defense_score) + capacites.getDegat().getValue();
			joueur.getSante().getDegat(degat, this);
			System.out.println("Vous avez été attaqué ! ( Dégât reçu : " + degat + ")");
			
			return true;
		}
		return false;
		
	}

	@Override
	public void mortaction() {
		// TODO Auto-generated method stub
		
	}

	
	


}
