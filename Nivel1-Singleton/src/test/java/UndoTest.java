import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {
    private Undo undo;

    @BeforeEach
    void setUp() {
        undo = Undo.getInstance();
}

    @Test
    public void shouldCreateUniqueInstance() {
        Undo undo1 = Undo.getInstance();

        assertSame(undo, undo1);
    }

    @Test
    public void shouldAddNewCommand() {
        undo.addCommand("cd carpeta");

        assertEquals("cd carpeta", undo.undoCommand());
    }

    @Test
    public void shouldRemoveLastCommand() {
        undo.addCommand("cd carpeta");
        undo.addCommand("mkdir carpeta");

        assertEquals("mkdir carpeta", undo.undoCommand());
        assertEquals("cd carpeta", undo.undoCommand());
    }

    @Test
    public void shouldReturnHistory() {
        undo.addCommand("cd carpeta");
        undo.addCommand("mkdir carpeta");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        undo.showHistory();

        String result = output.toString();

        assertTrue(result.contains("cd carpeta"));
        assertTrue(result.contains("mkdir carpeta"));
    }
}
