package tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Item;

public class Drop extends Task<ClientContext> {
    public final static int[] dropFish = { 317, 321, 335, 331, 23129};

    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull() || ctx.inventory.toStream().count() > 27;
    }

    @Override
    public void execute() {
        ctx.game.tab(Game.Tab.INVENTORY, true);
        if(ctx.inventory.isFull()){
            for(Item fishId : ctx.inventory.id(dropFish)){
                fishId.interact(true, "Drop");
                Condition.wait(() -> ctx.inventory.toStream().id(dropFish).count() == 0, Random.nextGaussian(130, 230, 150, 210), 3);
            }
        }
    }
}
