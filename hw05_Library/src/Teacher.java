public class Teacher extends User {

    Teacher(String firstname, String lastname, String street, String city, String country) {
        super(firstname, lastname, street, city, country);
    }

    @Override
    public Integer getLendingPeriod(RentObject ro) {
        return ro.getLendingPeriod(this);
    }

    @Override
    public Integer getLendingPrice() {
        return 0;
    }

    @Override
    public Integer getMaxExtensions() {
        return 2;
    }
}
