package lld.dream11;

/**
 * @author vinay.saini
 * @created 11/08/2020 - 10:36 AM
 */
public class Admin extends Person {

    Admin(String name) {
        this.name = name;
    }
    public void execute(Player player, int score) {
        player.play(score);
    }
}
