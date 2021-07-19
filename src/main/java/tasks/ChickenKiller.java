package tasks;

import Area.ChickenArea;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.Player;

public class ChickenKiller extends Task<ClientContext> {
    Npc chicken = ctx.npcs.toStream().name("Chicken").nearest().first();
    Player localPlayer;
    ChickenArea chickenArea = new ChickenArea(ctx);

    public ChickenKiller(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return chickenArea.playerInChickenArea(localPlayer)
                && ctx.players.local().animation() == -1
                && !ctx.players.local().interacting().valid();
    }

    @Override
    public void execute() {
        if(chickenArea.chickenOutsideArea(chicken)) {
            // TODO
            System.out.println("Ignoring chicken outside");
        }
        else if(chickenArea.chickenInArea(chicken) && chicken.valid()){
            chicken.interact("Attack");
        }
    }
}
