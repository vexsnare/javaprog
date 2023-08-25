package lld.dream11;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:35 AM
 */
public class User extends Person {
    Team team;
    //Not meeting constraints
    //String state;

    User(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void addPlayer(Player player) {
        if(player.partOf.stream().anyMatch(x -> x.teamName.equals(team.teamName))) {
            System.out.println("Can't add same player twice");
            return;
        }
        if(team.players.size() < 11) {
            this.team.addPlayer(player);
        }
        if(team.players.size() == 11) {
            System.out.println("Can't add more");
        }


    }


}
