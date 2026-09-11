package factory;

import formats.AddressData;
import formats.spain.SpainAddress;
import formats.spain.SpainPhone;
import interfaces.Address;
import interfaces.Phone;

public class SpainContactFactory implements ContactFactory {
    @Override
    public Address createAdress(AddressData data) {
        return new SpainAddress(data);
    }

    @Override
    public Phone createPhone(String number) {
        return new SpainPhone(number);
    }
}
