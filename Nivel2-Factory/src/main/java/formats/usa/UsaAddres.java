package formats.usa;

import formats.AddressData;
import interfaces.Address;

public class UsaAddres implements Address {
    private final AddressData data;

    public UsaAddres(AddressData data) {
        this.data = data;
    }


    @Override
    public String getAddress() {
        return data.getDireccion() + ", " + data.getCiudad() + ", " + data.getRegion().toUpperCase() + " "
                + data.getCp();
    }
}
