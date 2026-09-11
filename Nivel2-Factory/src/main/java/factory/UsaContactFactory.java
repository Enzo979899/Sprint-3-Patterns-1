package factory;

import formats.AddressData;
import formats.usa.UsaAddres;
import formats.usa.UsaPhone;
import interfaces.Address;
import interfaces.Phone;

public class UsaContactFactory implements ContactFactory {
    @Override
    public Address createAdress(AddressData data) {
        return new UsaAddres(data);
    }

    @Override
    public Phone createPhone(String number) {
        return new UsaPhone(number);
    }
}
