package formats.USA;

import formats.AddressData;
import interfaces.Address;

public class USAAddres implements Address {
    private final AddressData data;

    public USAAddres(AddressData data) {
        this.data = data;
    }


    @Override
    public String getAddress() {
        return data.getDireccion() + ", " + data.getCiudad() + ", " + data.getRegion().toUpperCase() + " "
                + data.getCp();
    }
}
