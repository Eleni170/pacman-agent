package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

public interface State {

    Action getAction();

    void setAction(Action action);

    Transition getTransition();

    void setTransition(Transition transition);

    Constants.MOVE execute(Game game);

}
