package entrants.pacman.epartalid.fsm.condition;

import entrants.pacman.epartalid.fsm.action.get.GetGhostNear;
import pacman.game.Constants;
import pacman.game.Game;

public class NotAnyGhostsAreTooClose implements Condition {

    private GetGhostNear getGhostNear;

    private int ghostLocation;
    private static final int MIN_DISTANCE = 20;

    public NotAnyGhostsAreTooClose() {
        this.getGhostNear = new GetGhostNear();
    }

    public int getGhostLocation() {
        return ghostLocation;
    }

    public void setGhostLocation(int ghostLocation) {
        this.ghostLocation = ghostLocation;
    }

    public boolean execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();

        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            getGhostNear.setGhost(ghost);
            ghostLocation = getGhostNear.execute(game);
            if (ghostLocation != -1) {
                if (game.getShortestPathDistance(current, ghostLocation) < MIN_DISTANCE) {
                    return false;
                }
            }
        }
        return true;
    }
}

