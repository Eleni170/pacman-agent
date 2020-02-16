package entrants.pacman.epartalid.btree.condition;

import pacman.game.Game;

import java.util.ArrayList;

public class ArePillsAvailable implements Condition {

    ArrayList<Integer> targets;

    public ArrayList<Integer> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Integer> targets) {
        this.targets = targets;
    }

    @Override
    public boolean execute(Game game) {
        return !targets.isEmpty();
    }
}
