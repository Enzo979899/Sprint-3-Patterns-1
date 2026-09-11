package factory;

import formats.AddressData;
import formats.USA.USAAddres;
import formats.USA.USAPhone;
import interfaces.Address;
import interfaces.Phone;

public class USAContactFactory implements ContactFactory {
    @Override
    public Address createAdress(AddressData data) {
        return new USAAddres(data);
    }

    @Override
    public Phone createPhone(String number) {
        return new USAPhone(number);
    }
}
