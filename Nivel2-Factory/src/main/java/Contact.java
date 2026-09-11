import factory.ContactFactory;
import formats.AddressData;
import interfaces.Address;
import interfaces.Phone;

public class Contact {
    private final Address direccion;
    private final Phone numero;

    public Contact(ContactFactory factory, AddressData addressData, String phoneNumber) {
        this.direccion = factory.createAdress(addressData);
        this.numero = factory.createPhone(phoneNumber);
    }

    public String getDireccion() {
        return direccion.getAddress();
    }

    public String getNumero() {
        return numero.getPhoneNumber();
    }
}
