package fr.mugiwara.mmorpg.game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import fr.mugiwara.mmorpg.player.Joueur;

public class Game {

	public static GameState state;
	private List<Joueur> players;
	public static Map map;
	public int round = 0;
	public int game_size = 2;
	public int round_step;
	
	public Game() {
		
		map = new Map();
		players = new ArrayList<Joueur>();
		
		state = GameState.WAITING;
		
		Joueur player = createFirstPlayer();
		
		addPlayer(player);
		
		startGame();
	}
	
	public boolean startGame() {
		
		boolean check = false;
		
		while(!check) {
			
			round_step = 0;
			
			while(round_step < game_size) {
				
				if(round_step == 0) {
					
					players.get(0).getMenu();
					
				} else if(round_step == 1) {
					
					System.out.println(" ");
					System.out.println("Les monstres jouent ..");
					System.out.println(" ");
					
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				round_step++;
			}
			round++;
		}
		
		return false;
		
	}
	
	public Joueur createFirstPlayer() {
		
		int random = (int) (Math.random() * (2));
		
		int[] pos = {192,212};
		
		System.out.println(random);
		
		int place = pos[random];
		
		Joueur one = new Joueur(place);
		return one;
	}
	
	public void addPlayer(Joueur j) {
		
		if(state == GameState.WAITING) {
			map.addEntite(j);
			players.add(j);
			
			checkLaunch();
			return;
		}
		
		System.out.println("Erreur, partie déjà en cours ..");
		
	}
	
	public void checkLaunch() {
		if(players.size() == 2) {
			
			System.out.println("Lancement du jeu en cours ..");
			
			setState(GameState.IN_PROGRESS);
			
		}
		
	}
	
	public static void StateAfficher() {
		System.out.println("Etat de la partie : " + Game.state.toString());
	}
	
	public void setState(GameState state) {
		Game.state = state;
	}
	
	
}
