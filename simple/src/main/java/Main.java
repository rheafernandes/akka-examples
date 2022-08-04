import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = null;
        try {
            system = ActorSystem.create("test-system");
            helloName(system);
            readAndWriteActor(system);
        } catch (Exception e) {
            if (system != null) system.terminate();
        }
    }

    public static void helloName(ActorSystem system) {
        ActorRef helloNameActor
                = system.actorOf(Props.create(HelloWorld.class), "hello-name-actor");
        helloNameActor.tell("Rhea", ActorRef.noSender());
    }

    public static void readAndWriteActor(ActorSystem system){
        ActorRef fileReaderActor
                = system.actorOf(Props.create(FileReader.class), "file-reader-actor");
        ActorRef fileWriterActor
                = system.actorOf(Props.create(FileWriter.class), "file-writer-actor");
        System.out.println("Actor Hierarchy Path File Reader" + fileReaderActor.path().toString());
        System.out.println("Actor Hierarchy Path File Writer" + fileWriterActor.path().toString());
        fileReaderActor.tell("/Users/rhea.fernandes/akka-demo/simple/src/main/resources/namesFromA.txt", ActorRef.noSender());
    }
}
