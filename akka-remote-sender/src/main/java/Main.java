import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.FromConfig;

public class Main {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("akka-remote");
        ActorRef fileReaderActor = actorSystem.actorOf(FromConfig.getInstance().props(FileReader.props()), "file-reader-actor");
        System.out.println("The Actor Hierarchy" + fileReaderActor.path().toString());
        fileReaderActor.tell("/Users/rhea.fernandes/akka-demo/akka-remote-sender/src/main/resources/namesFromD.txt", ActorRef.noSender());
    }
}
