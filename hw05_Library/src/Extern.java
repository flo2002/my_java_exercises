public class Extern extends User {

    Extern(String firstname, String lastname, String street, String city, String country) {
        super(firstname, lastname, street, city, country);
    }
    
    
    @Override
    public Integer getLendingPeriod(RentObject ro) {
        return ro.getLendingPeriod(this);
    }

    @Override
    public Integer getLendingPrice() {
        return 50;      // price in cents
    }

    @Override
    public Integer getMaxExtensions() {
        return 1;
    }
}
