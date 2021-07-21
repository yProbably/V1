package Area;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.Player;

public class ChickenArea extends ClientContext{

    public ChickenArea(ClientContext ctx) {
        super(ctx);
    }

    Area BARBARIAN_VILLAGE = new Area(
            new Tile(3104, 3422, 0),
            new Tile(3104, 3426, 0),
            new Tile(3111, 3433, 0),
            new Tile(3108, 3436, 0),
            new Tile(3102, 3436, 0),
            new Tile(3100, 3422, 0)
    );

    Area CHICKEN_AREA = new Area(
            new Tile(3182, 3289, 0),
            new Tile(3184, 3289, 0),
            new Tile(3186, 3291, 0),
            new Tile(3186, 3295, 0),
            new Tile(3187, 3296, 0),
            new Tile(3187, 3298, 0),
            new Tile(3186, 3299, 0),
            new Tile(3186, 3301, 0),
            new Tile(3184, 3303, 0),
            new Tile(3183, 3303, 0),
            new Tile(3182, 3304, 0),
            new Tile(3180, 3304, 0),
            new Tile(3180, 3307, 0),
            new Tile(3180, 3308, 0),
            new Tile(3173, 3308, 0),
            new Tile(3173, 3304, 0),
            new Tile(3169, 3300, 0),
            new Tile(3169, 3299, 0),
            new Tile(3170, 3298, 0),
            new Tile(3170, 3296, 0),
            new Tile(3169, 3294, 0),
            new Tile(3169, 3290, 0),
            new Tile(3171, 3289, 0),
            new Tile(3173, 3289, 0),
            new Tile(3175, 3288, 0),
            new Tile(3177, 3288, 0));

    public boolean walkToBarbVillage(){
        if(ctx().players.local().animation() == -1 && BARBARIAN_VILLAGE.contains(ctx().players.local())) {

        }
        return ctx().movement.walkTo(BARBARIAN_VILLAGE.getCentralTile());
    }
    public Npc nearestChicken(){
        return ctx().npcs.toStream().nearest().name("Cow").first();
    }

    public Player getLocalPlayer(){
        return ctx().players.local();
    }

    public boolean playerInChickenArea() {
        CHICKEN_AREA.contains(getLocalPlayer());
        return CHICKEN_AREA.contains(getLocalPlayer());
    }

    public boolean chickenOutsideArea() {
        return nearestChicken().inViewport() && !CHICKEN_AREA.contains(nearestChicken());
    }

    public boolean chickenInArea() {
        return nearestChicken().inViewport() && nearestChicken().valid() && CHICKEN_AREA.contains(nearestChicken());
    }
}
