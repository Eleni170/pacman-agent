package entrants.pacman.epartalid.fsm;

import entrants.pacman.epartalid.fsm.action.*;
import entrants.pacman.epartalid.fsm.condition.DidNotFindGhost;
import entrants.pacman.epartalid.fsm.condition.NotAnyGhostsAreTooClose;
import entrants.pacman.epartalid.fsm.condition.NotAnyMovesAreAvailable;
import entrants.pacman.epartalid.fsm.condition.NotAnyPillsOrPowerPillsAvailable;
import entrants.pacman.epartalid.fsm.state.*;
import entrants.pacman.epartalid.fsm.transition.*;
import pacman.game.Constants;
import pacman.game.Game;

public class FiniteStateMachine {

    private State currentState;

    public FiniteStateMachine() {
        createFiniteStateMachine();
    }

    public void createFiniteStateMachine() {

        State turnAround = new TurnAround(new MoveInOppositeDirection(), null);

        Transition pickRandomMoveToTurnAround = new PickRandomMoveToTurnAround(
                new NotAnyMovesAreAvailable(),
                turnAround
        );

        State pickRandomMove = new PickRandomMove(new MoveRandomly(), pickRandomMoveToTurnAround);

        Transition eatPillOrPowerPillToPickRandomMove = new EatPillOrPowerPillToPickRandomMove(
                new NotAnyPillsOrPowerPillsAvailable(),
                pickRandomMove
        );

        State eatPillOrPowerPill = new EatPillOrPowerPill(new MoveTowardsNearestPill(), eatPillOrPowerPillToPickRandomMove);

        Transition chaseToEatPillOrPowerPill = new ChaseToEatPillOrPowerPill(
                new DidNotFindGhost(),
                eatPillOrPowerPill
        );

        State chase = new Chase(new MoveTowardsGhost(), chaseToEatPillOrPowerPill);

        Transition surviveToChase = new SurviveToChase(
                new NotAnyGhostsAreTooClose(),
                chase
        );
        currentState = new Survive(new MoveAwayFromGhost(), surviveToChase);
    }

    public Constants.MOVE step(Game game) {

        State state = currentState;
        Transition transition = currentState.getTransition();

        while (transition != null) {
            if (transition.isTriggered(game)) {
                state = transition.getTargetState();
                transition = state.getTransition();
            } else {
                return state.execute(game);
            }
        }

        return state.execute(game);
    }

}
