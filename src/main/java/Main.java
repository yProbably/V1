import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import tasks.Drop;
import tasks.Fish;
import tasks.PlayerInArea;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(
        name = "Y's V1",
        description = "",
        version = "1.0.0")
public class Main extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<>();

    @Override
    public void start() {
        ctx.properties.setProperty("randomevents.disable", "true");
        ctx.properties.setProperty("singletap.disble", "true");
        taskList.add(new Drop(ctx));
        taskList.add(new Fish(ctx));
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
