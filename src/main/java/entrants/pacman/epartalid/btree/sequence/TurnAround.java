package entrants.pacman.epartalid.btree.sequence;

import entrants.pacman.epartalid.btree.action.MoveInOppositeDirection;
import pacman.game.Constants;
import pacman.game.Game;

public class TurnAround implements Sequence {

    private MoveInOppositeDirection moveInOppositeDirection;

    public TurnAround(MoveInOppositeDirection moveInOppositeDirection) {
        this.moveInOppositeDirection = moveInOppositeDirection;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        return moveInOppositeDirection.execute(game);
    }

}
