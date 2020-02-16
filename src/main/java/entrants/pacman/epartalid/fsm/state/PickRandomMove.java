package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.action.MoveRandomly;
import entrants.pacman.epartalid.fsm.condition.NotAnyMovesAreAvailable;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

public class PickRandomMove implements State {

    private Action moveRandomly;
    private Transition pickRandomMoveToTurnAround;

    public PickRandomMove(
            final Action moveRandomly,
            final Transition pickRandomMoveToTurnAround) {
        this.moveRandomly = moveRandomly;
        this.pickRandomMoveToTurnAround = pickRandomMoveToTurnAround;
    }

    @Override
    public Action getAction() {
        return moveRandomly;
    }

    @Override
    public void setAction(Action action) {
        this.moveRandomly = action;
    }

    @Override
    public Transition getTransition() {
        return pickRandomMoveToTurnAround;
    }

    @Override
    public void setTransition(Transition transition) {
        this.pickRandomMoveToTurnAround = transition;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        Constants.MOVE[] moves = ((NotAnyMovesAreAvailable) pickRandomMoveToTurnAround.getCondition()).getMoves();
        ((MoveRandomly) moveRandomly).setMoves(moves);
        return moveRandomly.execute(game);
    }
}
