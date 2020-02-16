package entrants.pacman.epartalid.fsm.condition;

import entrants.pacman.epartalid.fsm.action.get.GetNearestEdibleGhost;
import pacman.game.Constants;
import pacman.game.Game;

public class DidNotFindGhost implements Condition {

    private GetNearestEdibleGhost getNearestEdibleGhost;

    private Constants.GHOST minGhost;

    public DidNotFindGhost() {
        this.getNearestEdibleGhost = new GetNearestEdibleGhost();
    }

    public Constants.GHOST getMinGhost() {
        return minGhost;
    }

    public void setMinGhost(Constants.GHOST minGhost) {
        this.minGhost = minGhost;
    }

    @Override
    public boolean execute(Game game) {
        minGhost = getNearestEdibleGhost.execute(game);
        return minGhost == null;
    }
}
