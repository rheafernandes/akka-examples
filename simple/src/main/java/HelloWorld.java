import akka.actor.AbstractActor;
import akka.actor.Props;

public class HelloWorld extends AbstractActor {

    public static Props props() {
        return Props.create(HelloWorld.class, HelloWorld::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, (name) -> {
                    System.out.println("Hello " + name);
                }).build();
    }
}
