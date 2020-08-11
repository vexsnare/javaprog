package oops.dream11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:36 AM
 */
public class Team {
    public int score;
    String teamName;
    List<Player> players;
    String state;

    Team(String name) {
        this.teamName = name;
        this.score = 0;
        players = new ArrayList<>();
        this.state = "INVALID";
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.subscribeTeam(this);
    }

    private int get(String type) {
        return (int) players.stream().filter(x -> x.type.equals(type)).count();
    }

    public void validatePlayers() {
        if(players.size() < 4) {
            state = "INVALID";
        } else {
            int bowlers = get("bowler");
            int wicketkeepers = get("wicketKeeper");
            int batsman = get("batsman");
            if(bowlers >= 1 && batsman >= 1 && wicketkeepers >= 1) {
                state = "VALID";
            }
        }
    }

    public boolean isValid() {
        return state.equals("VALID");
    }
}
