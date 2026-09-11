package factory;

import formats.AddressData;
import interfaces.Address;
import interfaces.Phone;

public interface ContactFactory {
    Address createAdress(AddressData data);

    Phone createPhone(String number);
}
