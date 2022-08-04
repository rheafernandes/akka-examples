import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.FromConfig;

public class Main {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef nameActor = actorSystem.actorOf(FromConfig.getInstance().props(FileWriter.props()), "file-writer-actor");
        System.out.println("The Actor Hierarchy" + nameActor.path().toString());
    }
}
