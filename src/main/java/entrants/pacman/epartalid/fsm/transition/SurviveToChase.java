package entrants.pacman.epartalid.fsm.transition;

import entrants.pacman.epartalid.fsm.condition.Condition;
import entrants.pacman.epartalid.fsm.state.State;
import pacman.game.Game;

public class SurviveToChase implements Transition {

    private Condition notAnyGhostsAreTooClose;
    private State chase;

    public SurviveToChase(
            final Condition notAnyGhostsAreTooClose,
            final State chase) {
        this.notAnyGhostsAreTooClose = notAnyGhostsAreTooClose;
        this.chase = chase;
    }

    @Override
    public Condition getCondition() {
        return notAnyGhostsAreTooClose;
    }

    @Override
    public void setCondition(Condition condition) {
        this.notAnyGhostsAreTooClose = condition;
    }

    @Override
    public State getTargetState() {
        return chase;
    }

    @Override
    public void setTargetState(State targetState) {
        this.chase = targetState;
    }

    public boolean isTriggered(Game game) {
        return notAnyGhostsAreTooClose.execute(game);
    }

}
