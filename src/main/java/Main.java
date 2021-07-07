import org.powbot.stream.locatable.interactive.PlayerStream;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Players;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(
        name = "Y's V1",
        description = "",
        version = "1.0.0")
public class Main extends PollingScript<ClientContext> {

    public List<Task> taskList = new ArrayList<>();
    List<String> data = new ArrayList<String>();

    @Override
    public void start() {
        Players players = ctx.players;

        System.out.println(getName() + " is starting");
        if(ctx.players.toStream().within(20).count() > 1){
            ctx.game.logout();
        }
        /*
        data.add(ctx.players.toStream().any().name());
        String[] strObjects = data.toArray(new String[0]);
        for(String obj: strObjects) {
            System.out.println(obj);
        }
        */

        if(ctx.players.toStream().within(10).count() < 1){
            System.out.println("No players");
            super.stop();
        }
    }

    @Override
    public void poll() {

    }

    @Override
    public void stop() {
        System.out.println(getName() + " is stopping");
        super.stop();
    }
}
