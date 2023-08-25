package lld.dream11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:46 AM
 */
public class Driver {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("A", "bowler"));
        players.add(new Player("B", "wicketKeeper"));
        players.add(new Player("C", "batsman"));
        players.add(new Player("D", "wicketKeeper"));
        players.add(new Player("E", "wicketKeeper"));
        players.add(new Player("F", "batsman"));
        players.add(new Player("G", "batsman"));
        players.add(new Player("H", "batsman"));
        players.add(new Player("I", "bowler"));
        players.add(new Player("J", "bowler"));
        players.add(new Player("K", "bowler"));
        players.add(new Player("L", "bowler"));

        Admin admin = new Admin("admin");
        Game game = new Game(players, admin);


        // userA t1
        game.addUser(new User("userA", new Team("T1")));
        game.addUser(new User("userB", new Team("T2")));
        game.addUser(new User("userC", new Team("T3")));

        User userA = game.getUser("userA");
        userA.addPlayer(game.getPlayerFromPool("A"));
        //userA.addPlayer(game.getPlayerFromPool("A"));
        userA.addPlayer(game.getPlayerFromPool("B"));
        userA.addPlayer(game.getPlayerFromPool("C"));


        User userB = game.getUser("userB");
        userB.addPlayer(game.getPlayerFromPool("A"));
        userB.addPlayer(game.getPlayerFromPool("B"));
        userB.addPlayer(game.getPlayerFromPool("C"));
        userB.addPlayer(game.getPlayerFromPool("K"));


        User userC = game.getUser("userC");
        userC.addPlayer(game.getPlayerFromPool("E"));
        userC.addPlayer(game.getPlayerFromPool("L"));
        userC.addPlayer(game.getPlayerFromPool("G"));
        userC.addPlayer(game.getPlayerFromPool("D"));
        userC.addPlayer(game.getPlayerFromPool("A"));


        game.startGame();

        game.admin.execute(game.getPlayerFromPool("A"), 20);
        game.admin.execute(game.getPlayerFromPool("B"), 10);
        game.admin.execute(game.getPlayerFromPool("E"), 20);

        game.endGame();

    }
}
