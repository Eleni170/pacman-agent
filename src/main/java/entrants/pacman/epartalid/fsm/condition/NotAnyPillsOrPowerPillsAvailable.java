package entrants.pacman.epartalid.fsm.condition;

import entrants.pacman.epartalid.fsm.action.get.GetAvailablePills;
import pacman.game.Game;

import java.util.ArrayList;

public class NotAnyPillsOrPowerPillsAvailable implements Condition {

    private GetAvailablePills getAvailablePills;

    private ArrayList<Integer> targets;

    public NotAnyPillsOrPowerPillsAvailable() {
        getAvailablePills = new GetAvailablePills();
    }

    public ArrayList<Integer> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Integer> targets) {
        this.targets = targets;
    }

    @Override
    public boolean execute(Game game) {

        int[] pills = game.getPillIndices();
        int[] powerPills = game.getPowerPillIndices();

        targets = new ArrayList<>();

        getAvailablePills.setPills(pills);
        getAvailablePills.setTargets(targets);
        targets = getAvailablePills.execute(game);

        getAvailablePills.setPills(powerPills);
        getAvailablePills.setTargets(targets);
        targets = getAvailablePills.execute(game);

        return targets.isEmpty();
    }
}
