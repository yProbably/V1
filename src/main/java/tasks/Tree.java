package tasks;

import Area.ChickenArea;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Player;

import static org.powerbot.script.rt4.Constants.*;

public class Tree extends Task<ClientContext> {
    public final static String[] treeToCut = { "Tree", "Oak", "Willow", "Maple", "Yew" };
    ChickenArea chickenArea = new ChickenArea(ctx);
    Player localPlayer;

    public Tree(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.toStream().name("Bronze axe").count() > 0
                && ctx.objects.toStream().within(20).name(treeToCut).nearest().first().inViewport()
                && ctx.players.local().animation() == -1
                && (!ctx.players.local().interacting().valid())
                && ctx.inventory.toStream().count() < 28
                && !chickenArea.playerInChickenArea(localPlayer);
    }

    @Override
    public void execute() {
        if(ctx.players.local().tile().distanceTo(ctx.objects.toStream().name(treeToCut).nearest().first()) < 5
                && ctx.players.local().animation() == -1){

            if(ctx.skills.level(SKILLS_WOODCUTTING) < 15 && ctx.objects.toStream().name(treeToCut[0]).nearest().first().valid()){
                ctx.objects.toStream().name(treeToCut[0]).nearest().first().interact("Chop down");

                if(Condition.wait(() -> ctx.players.local().animation()!= -1 && !ctx.players.local().inMotion(), Random.nextGaussian(115, 250, 500), 3)){
                    Condition.wait(() -> !ctx.objects.toStream().at(ctx.objects.toStream().name(treeToCut[0]).nearest().first().tile()).name(treeToCut[0]).isEmpty() || ctx.inventory.toStream().count() == 28, Random.nextGaussian(115, 250, 500), 3);
                }
            }

            if((ctx.skills.level(SKILLS_WOODCUTTING) >= 15 && ctx.skills.level(SKILLS_WOODCUTTING) < 30) && ctx.objects.toStream().name(treeToCut[1]).nearest().first().valid()){
                ctx.objects.toStream().name(treeToCut[1]).nearest().first().interact("Chop down");

                if(Condition.wait(() -> ctx.players.local().animation()!= -1 && !ctx.players.local().inMotion(), Random.nextGaussian(115, 250, 500), 3)){
                    Condition.wait(() -> !ctx.objects.toStream().at(ctx.objects.toStream().name(treeToCut[1]).nearest().first().tile()).name(treeToCut[1]).isEmpty() || ctx.inventory.toStream().count() == 28, Random.nextGaussian(115, 250, 500), 3);
                }
            }

            if((ctx.skills.level(SKILLS_WOODCUTTING) >= 30 && ctx.skills.level(SKILLS_WOODCUTTING) < 60) && ctx.objects.toStream().name(treeToCut[2]).nearest().first().valid()){
                ctx.objects.toStream().name(treeToCut[2]).nearest().first().interact("Chop down");

                if(Condition.wait(() -> ctx.players.local().animation()!= -1 && !ctx.players.local().inMotion(), Random.nextGaussian(115, 250, 500), 3)){
                    Condition.wait(() -> !ctx.objects.toStream().at(ctx.objects.toStream().name(treeToCut[2]).nearest().first().tile()).name(treeToCut[2]).isEmpty() || ctx.inventory.toStream().count() == 28, Random.nextGaussian(115, 250, 500), 3);
                }
            }
        }
    }
}
