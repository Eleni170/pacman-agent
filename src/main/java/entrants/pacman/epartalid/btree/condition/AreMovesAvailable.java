package entrants.pacman.epartalid.btree.condition;

import pacman.game.Constants;
import pacman.game.Game;

public class AreMovesAvailable implements Condition {

    Constants.MOVE[] moves;

    public Constants.MOVE[] getMoves() {
        return moves;
    }

    public void setMoves(Constants.MOVE[] moves) {
        this.moves = moves;
    }

    @Override
    public boolean execute(Game game) {
        return (moves.length > 0);
    }
}
