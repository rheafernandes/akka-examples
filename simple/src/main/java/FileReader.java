import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Props;

import java.io.BufferedReader;

public class FileReader extends AbstractActor {
    public static Props props() {
        return Props.create(FileReader.class, FileReader::new);
    }

    private void tellAnother(String location) {
        ActorSelection fileWriter = getContext().actorSelection("akka://test-system/user/file-writer-actor");
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(location));
            String line = reader.readLine();
            while (line != null) {
                fileWriter.tell(line, getSelf());
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, (location) -> {
                    tellAnother(location);
                }).build();
    }
}