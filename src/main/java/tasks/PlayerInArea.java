package tasks;

import org.powerbot.script.rt4.ClientContext;

public class PlayerInArea extends Task<ClientContext>{

    public PlayerInArea(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.toStream().within(20).count() > 1 || ctx.players.toStream().within(10).count() < 2;
    }

    @Override
    public void execute() {

        if(ctx.players.toStream().within(20).count() > 2){
            System.out.println("One or more players in our area");
        }

        if(ctx.players.toStream().within(10).count() < 2){
            System.out.println("Only local player in our area");
            // TODO
        }
    }
}
