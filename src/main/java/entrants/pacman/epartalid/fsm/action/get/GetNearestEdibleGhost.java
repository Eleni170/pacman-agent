package entrants.pacman.epartalid.fsm.action.get;

import pacman.game.Constants;
import pacman.game.Game;

public class GetNearestEdibleGhost {

    public Constants.GHOST execute(Game game) {
        int current = game.getPacmanCurrentNodeIndex();

        int minDistance = Integer.MAX_VALUE;
        Constants.GHOST minGhost = null;
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostEdibleTime(ghost) > 0) {
                int distance = game.getShortestPathDistance(current, game.getGhostCurrentNodeIndex(ghost));
                if (distance < minDistance) {
                    minDistance = distance;
                    minGhost = ghost;
                }
            }
        }
        return minGhost;
    }
}
