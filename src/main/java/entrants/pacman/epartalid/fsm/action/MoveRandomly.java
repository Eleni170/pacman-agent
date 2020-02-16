package entrants.pacman.epartalid.fsm.action;

import pacman.game.Constants;
import pacman.game.Game;

import java.util.Random;

public class MoveRandomly implements Action {

    private Constants.MOVE[] moves;

    public Constants.MOVE[] getMoves() {
        return moves;
    }

    public void setMoves(Constants.MOVE[] moves) {
        this.moves = moves;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        Random random = new Random();
        return moves[random.nextInt(moves.length)];
    }
}
