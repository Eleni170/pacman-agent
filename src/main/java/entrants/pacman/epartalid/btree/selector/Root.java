package entrants.pacman.epartalid.btree.selector;

import entrants.pacman.epartalid.btree.action.*;
import entrants.pacman.epartalid.btree.action.MoveRandomly;
import entrants.pacman.epartalid.btree.condition.AreMovesAvailable;
import entrants.pacman.epartalid.btree.condition.ArePillsAvailable;
import entrants.pacman.epartalid.btree.condition.FoundGhost;
import entrants.pacman.epartalid.btree.condition.IsGhostTooClose;
import entrants.pacman.epartalid.btree.action.get.GetAvailablePills;
import entrants.pacman.epartalid.btree.action.get.GetGhostNear;
import entrants.pacman.epartalid.btree.action.get.GetNearestEdibleGhost;
import entrants.pacman.epartalid.btree.action.get.GetPossibleMoves;
import entrants.pacman.epartalid.btree.sequence.*;
import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;
import java.util.List;

public class Root implements Selector {

    private Game game;
    private List<Sequence> listSequence;

    public Root() {
        listSequence = new ArrayList<>();
        Sequence survive = new Survive(
                new GetGhostNear(),
                new IsGhostTooClose(),
                new MoveAwayFromGhost()
        );
        Sequence chase = new Chase(
                new GetNearestEdibleGhost(),
                new FoundGhost(),
                new MoveTowardsGhost()
        );
        Sequence eatPillOrPowerPill = new EatPillOrPowerPill(
                new GetAvailablePills(),
                new ArePillsAvailable(),
                new MoveTowardsNearestPill()
        );
        Sequence pickRandomMove = new PickRandomMove(
                new GetPossibleMoves(),
                new AreMovesAvailable(),
                new MoveRandomly()
        );
        Sequence turnAround = new TurnAround(
                new MoveInOppositeDirection()
        );

        listSequence.add(survive);
        listSequence.add(chase);
        listSequence.add(eatPillOrPowerPill);
        listSequence.add(pickRandomMove);
        listSequence.add(turnAround);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Constants.MOVE execute() {
        for (Sequence sequence : listSequence) {
            Constants.MOVE execute = sequence.execute(game);
            if (execute != null) {
                return execute;
            }
        }
        return null;
    }
}
