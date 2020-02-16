package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.action.MoveTowardsGhost;
import entrants.pacman.epartalid.fsm.condition.DidNotFindGhost;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

public class Chase implements State {

    private Action moveTowardsGhost;
    private Transition chaseToEatPillOrPowerPill;

    public Chase(final Action action,
                 final Transition chaseToEatPillOrPowerPill) {
        this.moveTowardsGhost = action;
        this.chaseToEatPillOrPowerPill = chaseToEatPillOrPowerPill;
    }

    @Override
    public Action getAction() {
        return moveTowardsGhost;
    }

    @Override
    public void setAction(Action action) {
        this.moveTowardsGhost = action;
    }

    @Override
    public Transition getTransition() {
        return chaseToEatPillOrPowerPill;
    }

    @Override
    public void setTransition(Transition transition) {
        this.chaseToEatPillOrPowerPill = transition;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        Constants.GHOST minGhost = ((DidNotFindGhost) chaseToEatPillOrPowerPill.getCondition()).getMinGhost();
        ((MoveTowardsGhost) moveTowardsGhost).setMinGhost(minGhost);
        return moveTowardsGhost.execute(game);
    }
}
