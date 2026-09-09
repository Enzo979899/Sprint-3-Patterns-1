import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    void shouldAddNewCommand() {
        undo.addCommand("cd carpeta");

        assertEquals("cd carpeta", undo.undoCommand());
    }

    @Test
    void shouldRemoveLastCommand() {
        undo.addCommand("cd carpeta");
        undo.addCommand("mkdir carpeta");

        assertEquals("mkdir carpeta", undo.undoCommand());
        assertEquals("cd carpeta", undo.undoCommand());
    }
}
