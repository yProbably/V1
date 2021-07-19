package tasks;

import Area.ChickenArea;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Player;

public class WalkToChickenArea extends Task<ClientContext> {
    ChickenArea chickenArea = new ChickenArea(ctx);
    Player localPlayer;
    public WalkToChickenArea(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !chickenArea.playerInChickenArea(localPlayer) && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Not in Chicken Area");
    }
}
