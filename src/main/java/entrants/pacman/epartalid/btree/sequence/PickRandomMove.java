package entrants.pacman.epartalid.btree.sequence;

import entrants.pacman.epartalid.btree.action.MoveRandomly;
import entrants.pacman.epartalid.btree.action.get.GetPossibleMoves;
import entrants.pacman.epartalid.btree.condition.AreMovesAvailable;
import pacman.game.Constants;
import pacman.game.Game;

public class PickRandomMove implements Sequence {

    private GetPossibleMoves getPossibleMoves;
    private AreMovesAvailable areMovesAvailable;
    private MoveRandomly moveRandomly;

    public PickRandomMove(
            final GetPossibleMoves getPossibleMoves,
            final AreMovesAvailable areMovesAvailable,
            final MoveRandomly moveRandomly) {
        this.getPossibleMoves = getPossibleMoves;
        this.areMovesAvailable = areMovesAvailable;
        this.moveRandomly = moveRandomly;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        Constants.MOVE[] moves = getPossibleMoves.execute(game);
        areMovesAvailable.setMoves(moves);
        if (areMovesAvailable.execute(game)) {
            moveRandomly.setMoves(moves);
            return moveRandomly.execute(game);
        }
        return null;
    }
}
