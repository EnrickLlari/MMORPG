package fr.mugiwara.mmorpg.game;

import java.util.ArrayList;
import java.util.List;

import fr.mugiwara.mmorpg.Init.Monsters;
import fr.mugiwara.mmorpg.Init.Objets;
import fr.mugiwara.mmorpg.monster.Monster;
import fr.mugiwara.mmorpg.player.Joueur;

/**
 * Class Game
 * @author Sanjeevan
 * @version 1.0
 */
public class Game {

	// VARIABLES
	 
	public static GameState state;
	public List<Joueur> players;
	public List<Monster> monsters;
	public static Map map;
	public int round = 0;
	public int game_size = 2;
	public int round_step;
	
	/**
	 * Constructeur de Game
	 */
	public Game() {
		
		map = new Map();
		players = new ArrayList<Joueur>();
		monsters = new ArrayList<Monster>();
		
		state = GameState.WAITING;
		

	}
	
	
	/**
	 * Lancer la partie
	 */
	public void launchGame() {
		
		Joueur player = createFirstPlayer();
		
		addPlayer(player);
		
		Objets.init_objets();
		
		Monsters.init_monsters();
		
		startGame();
		
	}
	
	
	/**
	 * Lancer le jeu
	 * @return Boolean
	 */
	public boolean startGame() {
		
		setState(GameState.IN_PROGRESS);
		
		boolean check = false;
		
		while(!check) {
			
			round_step = 0;
			
			while(round_step < game_size) {
				if(!state.equals(GameState.IN_PROGRESS)) {
					break;
				}
				
				
				if(round_step == 0) {
					
					Joueur first_player = players.get(0);
					first_player.getAct().generatePoints();
					
					boolean t_check = false;
					while(!t_check) {
						
						t_check = first_player.getMenu();
					}
					
					
				} else if(round_step == 1) {
					
					System.out.println(" ");
					System.out.println("Les monstres jouent ..");
					System.out.println(" ");
					
					for(Monster mob : monsters) {
						
						mob.tour();
						
						
					}
					

					
				}
				
				round_step++;
			}
			round++;
		}
		
		return false;
		
	}
	
	/**
	 * Créer le premier joueur
	 * @return Joueur
	 */
	public Joueur createFirstPlayer() {
		
		int random = (int) (Math.random() * (2));
		
		int[] pos = {192,212};
		
		System.out.println(random);
		
		int place = pos[random];
		
		Joueur one = new Joueur(place);
		return one;
	}
	
	/**
	 * Ajouter un joueur au jeu
	 * @param j
	 */
	public void addPlayer(Joueur j) {
		
		if(state == GameState.WAITING) {
			map.addEntite(j);
			players.add(j);
			
			checkLaunch();
			return;
		}
		
		System.out.println("Erreur, partie déjà en cours ..");
		
	}
	
	/**
	 * Changement de state si assez de joueur
	 */
	public void checkLaunch() {
		if(players.size() == 2) {
			
			System.out.println("Lancement du jeu en cours ..");
			
			setState(GameState.IN_PROGRESS);
			
		}
		
	}
	
	/**
	 * Afficher le stade de jeu
	 */
	public static void StateAfficher() {
		System.out.println("Etat de la partie : " + Game.state.toString());
	}
	
	/**
	 * Changer le stade de jeu
	 * @param GameState state
	 */
	public static void setState(GameState state) {
		Game.state = state;
	}
	
	
}
