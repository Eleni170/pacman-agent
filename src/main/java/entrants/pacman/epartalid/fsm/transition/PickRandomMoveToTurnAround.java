package entrants.pacman.epartalid.fsm.transition;

import entrants.pacman.epartalid.fsm.condition.Condition;
import entrants.pacman.epartalid.fsm.state.State;
import pacman.game.Game;

public class PickRandomMoveToTurnAround implements Transition {

    private Condition notAnyMovesAreAvailable;
    private State turnAround;

    public PickRandomMoveToTurnAround(
            final Condition notAnyMovesAreAvailable,
            final State turnAround) {
        this.notAnyMovesAreAvailable = notAnyMovesAreAvailable;
        this.turnAround = turnAround;
    }

    @Override
    public State getTargetState() {
        return turnAround;
    }

    @Override
    public void setTargetState(State targetState) {
        this.turnAround = targetState;
    }

    @Override
    public Condition getCondition() {
        return notAnyMovesAreAvailable;
    }

    @Override
    public void setCondition(Condition condition) {
        this.notAnyMovesAreAvailable = condition;
    }

    @Override
    public boolean isTriggered(Game game) {
        return notAnyMovesAreAvailable.execute(game);
    }

}
