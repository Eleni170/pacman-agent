package entrants.pacman.epartalid.btree.sequence;

import entrants.pacman.epartalid.btree.action.get.GetNearestEdibleGhost;
import entrants.pacman.epartalid.btree.action.MoveTowardsGhost;
import entrants.pacman.epartalid.btree.condition.FoundGhost;
import pacman.game.Constants;
import pacman.game.Game;

public class Chase implements Sequence {

    private GetNearestEdibleGhost getNearestEdibleGhost;
    private FoundGhost foundGhost;
    private MoveTowardsGhost moveTowardsGhost;

    public Chase(
            final GetNearestEdibleGhost getNearestEdibleGhost,
            final FoundGhost foundGhost,
            final MoveTowardsGhost moveTowardsGhost) {
        this.getNearestEdibleGhost = getNearestEdibleGhost;
        this.foundGhost = foundGhost;
        this.moveTowardsGhost = moveTowardsGhost;
    }

    @Override
    public Constants.MOVE execute(Game game) {

        Constants.GHOST minGhost = getNearestEdibleGhost.execute(game);
        foundGhost.setMinGhost(minGhost);
        if (foundGhost.execute(game)) {
            moveTowardsGhost.setMinGhost(minGhost);
            return moveTowardsGhost.execute(game);
        }
        return null;
    }
}
