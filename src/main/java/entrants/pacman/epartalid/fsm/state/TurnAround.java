package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

public class TurnAround implements State {

    private Action moveInOppositeDirection;
    private Transition noTransition;

    public TurnAround(Action moveInOppositeDirection, Transition noTransition) {
        this.moveInOppositeDirection = moveInOppositeDirection;
        this.noTransition = noTransition;
    }

    @Override
    public Action getAction() {
        return moveInOppositeDirection;
    }

    @Override
    public void setAction(Action action) {
        this.moveInOppositeDirection = action;
    }

    @Override
    public Transition getTransition() {
        return noTransition;
    }

    @Override
    public void setTransition(Transition transition) {
        this.noTransition = transition;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        return moveInOppositeDirection.execute(game);
    }
}
