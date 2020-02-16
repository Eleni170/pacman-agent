package entrants.pacman.epartalid.fsm.transition;

import entrants.pacman.epartalid.fsm.condition.Condition;
import entrants.pacman.epartalid.fsm.state.State;
import pacman.game.Game;

public class EatPillOrPowerPillToPickRandomMove implements Transition {

    private Condition notAnyPillsOrPowerPillsAvailable;
    private State pickRandomMove;

    public EatPillOrPowerPillToPickRandomMove(
            final Condition notAnyPillsOrPowerPillsAvailable,
            final State pickRandomMove) {
        this.notAnyPillsOrPowerPillsAvailable = notAnyPillsOrPowerPillsAvailable;
        this.pickRandomMove = pickRandomMove;
    }

    @Override
    public State getTargetState() {
        return pickRandomMove;
    }

    @Override
    public void setTargetState(State targetState) {
        this.pickRandomMove = targetState;
    }

    @Override
    public Condition getCondition() {
        return notAnyPillsOrPowerPillsAvailable;
    }

    @Override
    public void setCondition(Condition condition) {
        this.notAnyPillsOrPowerPillsAvailable = condition;
    }

    @Override
    public boolean isTriggered(Game game) {
        return notAnyPillsOrPowerPillsAvailable.execute(game);
    }

}
