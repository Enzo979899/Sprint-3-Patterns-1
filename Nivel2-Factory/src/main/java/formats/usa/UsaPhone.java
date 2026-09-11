package formats.usa;

import interfaces.Phone;

public class UsaPhone implements Phone {
    private static final String PREFIX = "+1 ";
    private final String numero;

    public UsaPhone(String numero) {
        this.numero = numero;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX + numero;
    }
}
