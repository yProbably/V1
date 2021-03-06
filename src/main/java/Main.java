import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import tasks.*;
import Area.ChickenArea;

import java.util.ArrayList;
import java.util.List;

import static org.powerbot.script.rt4.Constants.SKILLS_FISHING;

@Script.Manifest(
        name = "Y's AIO",
        description = "Do whatever you want"
)
/*
@Script.ScriptConfiguration(
        name = "Monster",
        description = "Pick a monster to kill",
        allowedValues = { "Chicken", "Goblin", "Farmer" }
)
@Script.ScriptConfiguration(
        name = "Location",
        description = "Pick a location to fight monsters",
        allowedValues = {"Lumbridge Chicken Area"}
)
@Script.ScriptConfiguration(
        name = "Powercut",
        description = "Tick this to drop logs when your inventory is full",
        optionType = ScriptConfigurationOption.OptionType.BOOLEAN
)*/
public class Main extends PollingScript<ClientContext> {

    private final List<Task> taskList = new ArrayList<>();
    ChickenArea chickenArea = new ChickenArea(ctx);

    @Override
    public void start() {
        ctx.properties.setProperty("randomevents.disable", "true");
        System.out.println(getName() + " is starting");
        System.out.println("Player: " + chickenArea.getLocalPlayer().name());
        System.out.println("Combat Level: " + chickenArea.getLocalPlayer().combatLevel());
        System.out.println("Fishing Level: " + ctx.skills.level(SKILLS_FISHING));
        //chickenArea.walkToBarbVillage();
        //taskList.add(new Drop(ctx));
        //taskList.add(new ChickenKiller(ctx));
        //taskList.add(new WalkToChickenArea(ctx));
        //taskList.add(new Fish(ctx));
        //taskList.add(new Tree(ctx));
        //taskList.add(new PlayerInArea(ctx));

    }

    @Override
    public void poll() {
        for (Task t : taskList) {
            if (t.activate()) {
                t.execute();
                break;
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
    }
}
