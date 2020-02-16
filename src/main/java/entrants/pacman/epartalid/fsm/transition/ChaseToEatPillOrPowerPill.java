package entrants.pacman.epartalid.fsm.transition;

import entrants.pacman.epartalid.fsm.condition.Condition;
import entrants.pacman.epartalid.fsm.state.State;
import pacman.game.Game;

public class ChaseToEatPillOrPowerPill implements Transition {

    private Condition didNotFindGhost;
    private State eatPillOrPowerPill;

    public ChaseToEatPillOrPowerPill(
            final Condition didNotFindGhost,
            final State eatPillOrPowerPill) {
        this.didNotFindGhost = didNotFindGhost;
        this.eatPillOrPowerPill = eatPillOrPowerPill;
    }

    @Override
    public State getTargetState() {
        return eatPillOrPowerPill;
    }

    @Override
    public void setTargetState(State targetState) {
        this.eatPillOrPowerPill = targetState;
    }

    @Override
    public Condition getCondition() {
        return didNotFindGhost;
    }

    @Override
    public void setCondition(Condition condition) {
        this.didNotFindGhost = condition;
    }

    @Override
    public boolean isTriggered(Game game) {
        return didNotFindGhost.execute(game);
    }

}
