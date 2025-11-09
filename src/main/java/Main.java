import io.javelit.core.Jt;
import io.javelit.core.Server;

public class Main {
    public static void main(String[] args) {
        final var server = Server.builder(() -> app(), 8080).build();
        server.start();
    }

    // the javelit app
    public static void app() {
        Jt.title("Hello World !").use();

        Jt.markdown("## A simple click app").use();

        // initialize state - values in the session state are maintained at each update
        Jt.sessionState().putIfAbsent("count", 0);

        // if button is clicked, increment the count value
        if (Jt.button("Click me").use()) {
            Jt.sessionState().computeIfPresentInt("count", (k, v) -> v + 1);
        }

        // display the count
        int count = Jt.sessionState().getInt("count");
        boolean plural = count > 1;
        Jt.markdown("The button was clicked **%s** time%s".formatted(count, plural ? "s" : ""))
                .use();


        // Use the imported library apache commons-math
        Jt.divider().use();
        Jt.markdown("## Using imported apache math dependency").use();
        Jt.text("Computed statistic with Apache commons-math: TODO").use();
    }
}
