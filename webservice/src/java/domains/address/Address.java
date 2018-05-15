package domains.address;

public class Address {
    private int cep;
    private String street;
    private String number;
    private String district;
    private String uf;
    private String country;

    public Address(String street, String number, String district, String uf, String country) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.uf = uf;
        this.country = country;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
