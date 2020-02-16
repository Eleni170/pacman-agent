package entrants.pacman.epartalid.btree.action;

import pacman.game.Constants;
import pacman.game.Game;

public class MoveInOppositeDirection implements Action {

    @Override
    public Constants.MOVE execute(Game game) {
        return game.getPacmanLastMoveMade().opposite();
    }
}
