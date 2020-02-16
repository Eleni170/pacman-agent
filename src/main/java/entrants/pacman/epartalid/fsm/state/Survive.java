package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.action.MoveAwayFromGhost;
import entrants.pacman.epartalid.fsm.condition.NotAnyGhostsAreTooClose;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

public class Survive implements State {

    private Action moveAwayFromGhost;
    private Transition surviveToChase;

    public Survive(final Action moveAwayFromGhost,
                   final Transition surviveToChase) {
        this.moveAwayFromGhost = moveAwayFromGhost;
        this.surviveToChase = surviveToChase;
    }

    @Override
    public Action getAction() {
        return moveAwayFromGhost;
    }

    @Override
    public void setAction(Action action) {
        this.moveAwayFromGhost = action;
    }

    @Override
    public Transition getTransition() {
        return surviveToChase;
    }

    @Override
    public void setTransition(Transition transition) {
        this.surviveToChase = transition;
    }

    public Constants.MOVE execute(Game game) {
        int ghostLocation = ((NotAnyGhostsAreTooClose) surviveToChase.getCondition()).getGhostLocation();
        ((MoveAwayFromGhost) moveAwayFromGhost).setGhostLocation(ghostLocation);
        return moveAwayFromGhost.execute(game);
    }
}
