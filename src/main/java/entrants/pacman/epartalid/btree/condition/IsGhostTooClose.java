package entrants.pacman.epartalid.btree.condition;

import pacman.game.Game;

public class IsGhostTooClose implements Condition {

    private static final int MIN_DISTANCE = 20;
    private int ghostLocation;

    public void setGhostLocation(int ghostLocation) {
        this.ghostLocation = ghostLocation;
    }

    public boolean execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();
        return (game.getShortestPathDistance(current, ghostLocation) < MIN_DISTANCE);
    }
}

