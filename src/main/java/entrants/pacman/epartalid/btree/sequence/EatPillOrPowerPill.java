package entrants.pacman.epartalid.btree.sequence;

import entrants.pacman.epartalid.btree.action.get.GetAvailablePills;
import entrants.pacman.epartalid.btree.action.MoveTowardsNearestPill;
import entrants.pacman.epartalid.btree.condition.ArePillsAvailable;
import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;

public class EatPillOrPowerPill implements Sequence {

    private GetAvailablePills getAvailablePills;
    private ArePillsAvailable arePillsAvailable;
    private MoveTowardsNearestPill moveTowardsNearestPill;

    public EatPillOrPowerPill(
            final GetAvailablePills getAvailablePills,
            final ArePillsAvailable arePillsAvailable,
            final MoveTowardsNearestPill moveTowardsNearestPill) {
        this.getAvailablePills = getAvailablePills;
        this.arePillsAvailable = arePillsAvailable;
        this.moveTowardsNearestPill = moveTowardsNearestPill;
    }

    @Override
    public Constants.MOVE execute(Game game) {
        int[] pills = game.getPillIndices();
        int[] powerPills = game.getPowerPillIndices();

        ArrayList<Integer> targets = new ArrayList<Integer>();

        getAvailablePills.setPills(pills);
        getAvailablePills.setTargets(targets);
        targets = getAvailablePills.execute(game);

        getAvailablePills.setPills(powerPills);
        getAvailablePills.setTargets(targets);
        targets = getAvailablePills.execute(game);

        arePillsAvailable.setTargets(targets);

        if (arePillsAvailable.execute(game)) {
            moveTowardsNearestPill.setTargets(targets);
            return moveTowardsNearestPill.execute(game);
        }
        return null;
    }
}
