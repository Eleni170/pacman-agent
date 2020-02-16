package entrants.pacman.epartalid.btree;

import entrants.pacman.epartalid.btree.selector.Root;
import entrants.pacman.epartalid.btree.selector.Selector;
import pacman.game.Constants;
import pacman.game.Game;

public class BehaviorTree {

    private Selector selector;

    public BehaviorTree() {
        selector = new Root();
    }

    public void setGame(Game game) {
        ((Root) selector).setGame(game);
    }

    public Constants.MOVE step() {
        return selector.execute();
    }
}
