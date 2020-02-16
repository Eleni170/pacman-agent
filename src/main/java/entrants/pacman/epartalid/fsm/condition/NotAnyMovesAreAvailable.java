package entrants.pacman.epartalid.fsm.condition;

import entrants.pacman.epartalid.fsm.action.get.GetPossibleMoves;
import pacman.game.Constants;
import pacman.game.Game;

public class NotAnyMovesAreAvailable implements Condition {

    private GetPossibleMoves getPossibleMoves;

    private Constants.MOVE[] moves;

    public NotAnyMovesAreAvailable() {
        getPossibleMoves = new GetPossibleMoves();
    }

    public Constants.MOVE[] getMoves() {
        return moves;
    }

    public void setMoves(Constants.MOVE[] moves) {
        this.moves = moves;
    }

    @Override
    public boolean execute(Game game) {
        moves = getPossibleMoves.execute(game);
        return (moves.length <= 0);
    }
}
