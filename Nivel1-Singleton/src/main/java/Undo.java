import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo undo = new Undo();
    private final List<String> commands = new ArrayList<>();

    private Undo() {}

    public static Undo getInstance() {
        return undo;
    }

    public void addCommand(String message) {
        commands.add(message);
    }

    public String undoCommand() {
        return commands.removeLast();
    }

    public void showHistory() {
        for(String command : commands) {
            System.out.println(command);
        }
    }
}
