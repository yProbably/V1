package Area;

import org.powerbot.script.Locatable;
import org.powerbot.script.Tile;

public enum ChickenArea implements Locatable {

    CHICKEN_AREA {
        @Override
        public Tile tile() {
            return Tile.NIL;
        }

        Tile[] chickenArea = {
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
        };
    };
}
