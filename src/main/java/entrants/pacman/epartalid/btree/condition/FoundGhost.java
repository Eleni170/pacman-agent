package entrants.pacman.epartalid.btree.condition;

import pacman.game.Constants;
import pacman.game.Game;

public class FoundGhost implements Condition {

    Constants.GHOST minGhost;

    public Constants.GHOST getMinGhost() {
        return minGhost;
    }

    public void setMinGhost(Constants.GHOST minGhost) {
        this.minGhost = minGhost;
    }

    @Override
    public boolean execute(Game game) {
        return (minGhost != null);
    }
}
