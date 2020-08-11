package oops.dream11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:35 AM
 */
public class Player extends Person {
    String type;
    Set<Team> partOf = new HashSet<>();

    Player(String playerName, String type) {
        this.name = playerName;
        this.type = type;
    }

    public void  subscribeTeam(Team team) {
        partOf.add(team);
    }


    public void play(int score) {

        for (Team t: partOf) {
            if(t.state.equals("VALID")) {
                t.score += score;
            }
        }
    }
}
