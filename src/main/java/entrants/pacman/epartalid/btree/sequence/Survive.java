package entrants.pacman.epartalid.btree.sequence;

import entrants.pacman.epartalid.btree.action.get.GetGhostNear;
import entrants.pacman.epartalid.btree.action.MoveAwayFromGhost;
import entrants.pacman.epartalid.btree.condition.IsGhostTooClose;
import pacman.game.Constants;
import pacman.game.Game;

public class Survive implements Sequence {

    private GetGhostNear getGhostNear;
    private IsGhostTooClose isGhostTooClose;
    private MoveAwayFromGhost moveAwayFromGhost;

    public Survive(final GetGhostNear getGhostNear,
                   final IsGhostTooClose isGhostTooClose,
                   final MoveAwayFromGhost moveAwayFromGhost) {
        this.getGhostNear = getGhostNear;
        this.isGhostTooClose = isGhostTooClose;
        this.moveAwayFromGhost = moveAwayFromGhost;
    }

    public Constants.MOVE execute(final Game game) {

        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            getGhostNear.setGhost(ghost);
            int ghostLocation = getGhostNear.execute(game);
            if (ghostLocation != -1) {
                isGhostTooClose.setGhostLocation(ghostLocation);
                if (isGhostTooClose.execute(game)) {
                    moveAwayFromGhost.setGhostLocation(ghostLocation);
                    return moveAwayFromGhost.execute(game);
                }
            }
        }
        return null;
    }
}
