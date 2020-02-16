package entrants.pacman.epartalid.fsm.transition;

import entrants.pacman.epartalid.fsm.condition.Condition;
import entrants.pacman.epartalid.fsm.state.State;
import pacman.game.Game;

public interface Transition {

    State getTargetState();

    void setTargetState(State targetState);

    Condition getCondition();

    void setCondition(Condition condition);

    boolean isTriggered(Game game);
}
