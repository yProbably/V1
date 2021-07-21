package tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

import java.util.stream.Collectors;

public class Fish extends Task<ClientContext>{
    public final static int[] fishingSpotId = { 1526, 1530 };
    public Npc currentFishingSpot;

    public Fish(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(){

        return ctx.inventory.toStream().name("Small fishing net").count() > 0
                || ctx.inventory.toStream().name("Fly fishing rod").count() > 0
                || ctx.inventory.toStream().name("Feather").count(true) > 1
                && ctx.players.local().animation() == -1
                //&& (ctx.inventory.toStream().count() < 28)
                && ctx.npcs.toStream().id(fishingSpotId).nearest().first().inViewport();
    }

    @Override
    public void execute() {
        if(ctx.npcs.toStream().id(fishingSpotId).nearest().first().inViewport()){
            if (ctx.npcs.toStream().id(fishingSpotId).nearest().limit(4).count() > 0) currentFishingSpot = ctx.npcs.toStream().id(fishingSpotId).nearest().limit(4).collect(Collectors.toList()).get(0);
            for (Npc n : ctx.npcs.toStream().id(fishingSpotId).nearest().limit(4).collect(Collectors.toList())) {
                if (n.interacting().valid()) {
                    currentFishingSpot = n;
                }
            }
            if(currentFishingSpot.inViewport()){
                if(currentFishingSpot.valid()){
                    currentFishingSpot.interact("Net");

                    if(Condition.wait(() -> ctx.players.local().animation() != -1, Random.nextGaussian(115, 250, 500), 3)){
                        System.out.println("Waiting");
                        Condition.wait(() -> !currentFishingSpot.valid() || ctx.inventory.toStream().count() == 28, Random.nextGaussian(115, 250, 500), 3);
                        System.out.println("Not waiting");
                    }
                }
            }
            else {
                ctx.movement.step(currentFishingSpot);
                ctx.camera.turnTo(currentFishingSpot);

                Condition.wait(() -> currentFishingSpot.inViewport(), Random.nextGaussian(115, 250, 500), 10);

            }
        }
    }
}
