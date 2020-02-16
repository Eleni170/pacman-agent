package entrants.pacman.epartalid.fsm.action.get;

import pacman.game.Constants;
import pacman.game.Game;

public class GetPossibleMoves {

    public Constants.MOVE[] execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();
        return game.getPossibleMoves(current, game.getPacmanLastMoveMade());
    }

}
