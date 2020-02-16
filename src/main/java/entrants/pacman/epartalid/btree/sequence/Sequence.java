package entrants.pacman.epartalid.btree.sequence;

import pacman.game.Constants;
import pacman.game.Game;

public interface Sequence {

    Constants.MOVE execute(Game game);
}
