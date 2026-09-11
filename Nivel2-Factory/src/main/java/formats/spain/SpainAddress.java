package formats.spain;

import formats.AddressData;
import interfaces.Address;

public class SpainAddress  implements Address {
    private final AddressData data;

    public SpainAddress(AddressData data) {
        this.data = data;
    }


    @Override
    public String getAddress() {
        return data.getDireccion() + ", " + data.getCp() + " " + data.getCiudad();
    }
}
