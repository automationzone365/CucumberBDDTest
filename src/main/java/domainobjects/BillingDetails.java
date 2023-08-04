package domainobjects;

public class    BillingDetails {
    private String billingFirstName;
    private String billingLastName;
    private String billingEmail;
    private String billingCompany;
    private String billingCountry;
    private String billingCity;
    private String billingAddressOne;
    private String billingZip;
    private String billingPhone;

    public BillingDetails(String billingFirstName, String billingLastName, String billingEmail,
                          String billingCompany, String billingCountry, String billingCity,
                          String billingAddressOne, String billingZip, String billingPhone) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingEmail = billingEmail;
        this.billingCompany = billingCompany;
        this.billingCountry = billingCountry;
        this.billingCity = billingCity;
        this.billingAddressOne = billingAddressOne;
        this.billingZip = billingZip;
        this.billingPhone = billingPhone;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public void setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public void setBillingAddressOne(String billingAddressOne) {
        this.billingAddressOne = billingAddressOne;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public String getBillingCompany() {
        return billingCompany;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingAddressOne() {
        return billingAddressOne;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public String getBillingPhone() {
        return billingPhone;
    }
}
