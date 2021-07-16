package tasks;

import Area.ChickenArea;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt4.ClientContext;

import static Area.ChickenArea.CHICKEN_AREA;
import static org.powerbot.script.rt4.Constants.*;

public class WalkToChickenArea extends Task<ClientContext> {

    public WalkToChickenArea(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.skills.level(SKILLS_ATTACK) <= 15
                || ctx.skills.level(SKILLS_STRENGTH) <= 15
                || ctx.skills.level(SKILLS_DEFENSE) <= 15
                && !CHICKEN_AREA.tile().equals(ctx.players.local());
    }

    @Override
    public void execute() {
        ;
        System.out.println(ctx.movement.findPath(CHICKEN_AREA).traverse());
    }
}
