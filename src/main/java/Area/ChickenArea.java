package Area;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.Player;

public class ChickenArea extends ClientContext{
    private Area CHICKEN_AREA;

    public ChickenArea(ClientContext ctx) {
        super(ctx);
    }

    public void inChickenArea(){
        CHICKEN_AREA = new Area(
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
                new Tile(3177, 3288, 0)
        );
    }

    private Npc nearestChicken(Npc chicken){
        chicken = ctx().npcs.toStream().nearest().name("Chicken").first();
        return chicken;
    }

    private Player getLocalPlayer(Player localPlayer){
        localPlayer = ctx().players.local();
        return localPlayer;
    }

    public boolean playerInChickenArea(Player localPlayer) {
        return CHICKEN_AREA.contains(getLocalPlayer(localPlayer));
    }

    public boolean chickenOutsideArea(Npc chicken) {
        System.out.println("The chicken is outside Area");
        return nearestChicken(chicken).inViewport() && !CHICKEN_AREA.contains(nearestChicken(chicken));
    }

    public boolean chickenInArea(Npc chicken) {
        System.out.println("The chicken is our area");
        return (nearestChicken(chicken).inViewport() && CHICKEN_AREA.contains(nearestChicken(chicken)));
    }
}
