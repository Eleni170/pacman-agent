package entrants.pacman.epartalid.fsm.action.get;

import pacman.game.Constants;
import pacman.game.Game;

public class GetGhostNear {

    private Constants.GHOST ghost;

    public Constants.GHOST getGhost() {
        return ghost;
    }

    public void setGhost(Constants.GHOST ghost) {
        this.ghost = ghost;
    }

    public int execute(Game game) {
        if (game.getGhostEdibleTime(ghost) == 0 && game.getGhostLairTime(ghost) == 0) {
            return game.getGhostCurrentNodeIndex(ghost);
        }
        return -1;
    }
}
