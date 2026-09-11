package formats;

public class AddressData {
    private final String direccion;
    private final String ciudad;
    private final String region;
    private final String cp;

    public AddressData(String direccion, String ciudad, String region, String cp) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getRegion() {
        return region;
    }

    public String getCp() {
        return cp;
    }
}
