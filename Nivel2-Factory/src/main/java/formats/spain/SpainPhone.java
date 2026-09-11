package formats.spain;

import interfaces.Phone;

public class SpainPhone implements Phone {
    private static final String PREFIX = "+34 ";
    private final String numero;

    public SpainPhone(String numero) {
        this.numero = numero;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX + numero;
    }
}
