import factory.SpainContactFactory;
import factory.UsaContactFactory;
import formats.AddressData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Test
    public void shouldCreateSpanishContact() {

        AddressData addressData = new AddressData("Carrer Example", "Barcelona", null,
                "08001");

        Contact contact = new Contact(new SpainContactFactory(), addressData, "600123456");

        assertEquals("Carrer Example, 08001 Barcelona", contact.getDireccion());

        assertEquals("+34 600123456", contact.getNumero());
    }

    @Test
    public void shouldCreateUSAContact() {

        AddressData addressData = new AddressData("Example Street", "New York", "NY",
                "10001");

        Contact contact = new Contact(new UsaContactFactory(), addressData, "2125551234");

        assertEquals("Example Street, New York, NY 10001", contact.getDireccion());

        assertEquals("+1 2125551234", contact.getNumero());
    }
}