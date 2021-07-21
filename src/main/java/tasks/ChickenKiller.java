package tasks;

import Area.ChickenArea;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class ChickenKiller extends Task<ClientContext> {
    ChickenArea chickenArea = new ChickenArea(ctx);

    public ChickenKiller(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return chickenArea.playerInChickenArea()
                && ctx.players.local().animation() == -1
                && !ctx.npcs.toStream().name("Cow").first().interacting().equals(ctx.players.local());
    }

    @Override
    public void execute() {
        if(!ctx.players.local().inMotion() && ctx.npcs.toStream().nearest().name("Cow").first().valid()){
            if(chickenArea.chickenInArea() && ctx.npcs.toStream().nearest().name("Cow").first().animation() == -1 && !ctx.npcs.toStream().nearest().name("Cow").first().interacting().equals(ctx.players.local())){
                ctx.npcs.toStream().nearest().name("Cow").first().interact("Attack");
                Condition.wait(() -> ctx.npcs.toStream().nearest().name("Cow").first().interacting().equals(ctx.players.local()), 150, 10);
            }
        }
    }
}
