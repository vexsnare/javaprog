package lld.dream11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:36 AM
 */

/*
  1 g - Admin
  1 g - register
  1 g - pool of players

 */
public class Game {
    int gameId;
    Map<String, Player> playersPool;
    Admin admin;
    Map<String, User> usersMap;

    Game(List<Player> players, Admin admin) {
        playersPool = new HashMap<>();
        usersMap = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            playersPool.put(players.get(i).name, players.get(i));
        }
        this.admin = admin;
    }



    public void addUser(User user) {
        this.usersMap.put(user.name, user);
    }

    public User getUser(String name) {
        if(!usersMap.containsKey(name)) {
            return null;
        }
        return usersMap.get(name);
    }

    public Player getPlayerFromPool(String name) {
        return playersPool.get(name);
    }

    public void startGame() {
        for (String user : usersMap.keySet()) {
            Team t = usersMap.get(user).getTeam();
            t.validatePlayers();
        }
        for(String name: playersPool.keySet()) {
            Player player = playersPool.get(name);

//            for(Team team: player.partOf) {
//                if(!team.isValid()) {
//                    player.partOf.remove(team);
//                }
//            }

        }
    }



    public int endGame() {
        for(String user: usersMap.keySet()) {
            System.out.print(user + " ");
            Team t = usersMap.get(user).getTeam();
            if(t.isValid()) {
                System.out.print(t.score);
            } else {
                System.out.print("Invalid Team.");
            }
            System.out.println();
        }
        return 0;
    }
}
