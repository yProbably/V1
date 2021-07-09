package tasks;

import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import static org.powerbot.script.rt4.Game.Tab.*;

public class Drop extends Task<ClientContext> {
    public final int[] dropFish = { 317, 321, 335, 331, 23129 };
    public final String[] dropLog = { "Logs", "Oak logs", "Willow logs", "Yew logs" };

    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.toStream().count() > 27 && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        if(ctx.game.tab(INVENTORY) && ctx.inventory.isFull()){
            for (Item logId : ctx.inventory.name(dropLog)){
                logId.interact("Drop");
            }

            for (Item fishId : ctx.inventory.id(dropFish)){
                fishId.interact("Drop");
            }

        } else {
            ctx.game.tab(INVENTORY, true);
        }
    }
}
