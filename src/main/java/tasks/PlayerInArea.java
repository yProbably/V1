package tasks;

import org.powbot.stream.locatable.interactive.PlayerStream;
import org.powerbot.script.rt4.ClientContext;

public class PlayerInArea extends Task<ClientContext>{

    public PlayerInArea(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public PlayerStream activate() {
        return ctx.players.toStream().within(10);
    }

    @Override
    public void execute() {
        System.out.println(ctx.players.toStream().name("").within(10));
        System.out.println(ctx.groundItems.toStream().name(""));
    }
}
