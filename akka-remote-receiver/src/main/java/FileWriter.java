import akka.actor.AbstractActor;
import akka.actor.Props;

public class FileWriter extends AbstractActor {
    public static Props props() {
        return Props.create(FileWriter.class, FileWriter::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, (name) -> {
                    System.out.println("Hello " + name);
                }).build();
    }
}