import factory.SpainContactFactory;
import factory.USAContactFactory;
import formats.AddressData;

public class Launcher {

    public static void run() {

        AddressData direccionEspana = new AddressData(
                "Carrer Example",
                "Barcelona",
                null,
                "08001"
        );

        Contact contactoEspana = new Contact(
                new SpainContactFactory(),
                direccionEspana,
                "600123456"
        );

        System.out.println(contactoEspana.getDireccion());
        System.out.println(contactoEspana.getNumero());


        AddressData direccionUSA = new AddressData(
                "Example Street",
                "New York",
                "NY",
                "10001"
        );

        Contact contactoUSA = new Contact(
                new USAContactFactory(),
                direccionUSA,
                "2125551234"
        );

        System.out.println(contactoUSA.getDireccion());
        System.out.println(contactoUSA.getNumero());
    }
}
