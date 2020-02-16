package entrants.pacman.epartalid.fsm.state;

import entrants.pacman.epartalid.fsm.action.Action;
import entrants.pacman.epartalid.fsm.action.MoveTowardsNearestPill;
import entrants.pacman.epartalid.fsm.condition.NotAnyPillsOrPowerPillsAvailable;
import entrants.pacman.epartalid.fsm.transition.Transition;
import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;

public class EatPillOrPowerPill implements State {

    private Action moveTowardsNearestPill;
    private Transition eatPillOrPowerPillToPickRandomMove;

    public EatPillOrPowerPill(
            final Action moveTowardsNearestPill,
            final Transition eatPillOrPowerPillToPickRandomMove) {
        this.moveTowardsNearestPill = moveTowardsNearestPill;
        this.eatPillOrPowerPillToPickRandomMove = eatPillOrPowerPillToPickRandomMove;
    }

    @Override
    public Action getAction() {
        return moveTowardsNearestPill;
    }

    @Override
    public void setAction(Action action) {
        this.moveTowardsNearestPill = action;
    }

    @Override
    public Transition getTransition() {
        return eatPillOrPowerPillToPickRandomMove;
    }

    @Override
    public void setTransition(Transition transition) {
        this.eatPillOrPowerPillToPickRandomMove = transition;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        ArrayList<Integer> targets = ((NotAnyPillsOrPowerPillsAvailable) eatPillOrPowerPillToPickRandomMove.getCondition()).getTargets();
        ((MoveTowardsNearestPill) moveTowardsNearestPill).setTargets(targets);
        return moveTowardsNearestPill.execute(game);
    }
}
