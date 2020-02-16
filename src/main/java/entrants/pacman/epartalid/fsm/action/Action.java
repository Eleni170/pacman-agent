package entrants.pacman.epartalid.fsm.action;

import pacman.game.Constants;
import pacman.game.Game;

public interface Action {

    Constants.MOVE execute(Game game);
}
