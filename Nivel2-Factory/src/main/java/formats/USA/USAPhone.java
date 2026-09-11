package formats.USA;

import interfaces.Phone;

public class USAPhone implements Phone {
    private static final String PREFIX = "+1 ";
    private final String numero;

    public USAPhone(String numero) {
        this.numero = numero;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX + numero;
    }
}
