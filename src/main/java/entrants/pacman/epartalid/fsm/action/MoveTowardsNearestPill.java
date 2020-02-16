package entrants.pacman.epartalid.fsm.action;

import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;

public class MoveTowardsNearestPill implements Action {

    private ArrayList<Integer> targets;

    public ArrayList<Integer> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Integer> targets) {
        this.targets = targets;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();

        int[] targetsArray = new int[targets.size()];
        for (int i = 0; i < targetsArray.length; i++) {
            targetsArray[i] = targets.get(i);
        }

        return game.getNextMoveTowardsTarget(
                current,
                game.getClosestNodeIndexFromNodeIndex(current, targetsArray, Constants.DM.PATH),
                Constants.DM.PATH
        );
    }
}
