package entrants.pacman.epartalid.btree.action;

import pacman.game.Constants;
import pacman.game.Game;

public class MoveTowardsGhost implements Action {

    Constants.GHOST minGhost;

    public Constants.GHOST getMinGhost() {
        return minGhost;
    }

    public void setMinGhost(Constants.GHOST minGhost) {
        this.minGhost = minGhost;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();
        return game.getNextMoveTowardsTarget(current, game.getGhostCurrentNodeIndex(minGhost), Constants.DM.PATH);
    }
}
