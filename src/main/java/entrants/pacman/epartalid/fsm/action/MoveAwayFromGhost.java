package entrants.pacman.epartalid.fsm.action;

import pacman.game.Constants;
import pacman.game.Game;

public class MoveAwayFromGhost implements Action {

    private int ghostLocation;

    public int getGhostLocation() {
        return ghostLocation;
    }

    public void setGhostLocation(int ghostLocation) {
        this.ghostLocation = ghostLocation;
    }

    public Constants.MOVE execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();
        return game.getNextMoveAwayFromTarget(current, ghostLocation, Constants.DM.PATH);
    }
}
