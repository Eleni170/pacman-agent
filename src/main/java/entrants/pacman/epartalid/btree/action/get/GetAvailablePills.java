package entrants.pacman.epartalid.btree.action.get;

import pacman.game.Game;

import java.util.ArrayList;

public class GetAvailablePills {

    private int[] pills;
    private ArrayList<Integer> targets;

    public int[] getPills() {
        return pills;
    }

    public void setPills(int[] pills) {
        this.pills = pills;
    }

    public ArrayList<Integer> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Integer> targets) {
        this.targets = targets;
    }

    public ArrayList<Integer> execute(Game game) {
        for (int i = 0; i < pills.length; i++) {
            Boolean pillStillAvailable = game.isPillStillAvailable(i);
            if (pillStillAvailable != null) {
                if (pillStillAvailable) {
                    targets.add(pills[i]);
                }
            }
        }
        return targets;
    }
}
