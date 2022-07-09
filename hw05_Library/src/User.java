public abstract class User {
    private static Integer _IDCounter = 0;
    private Integer _id;
	private String _firstname;
	private String _lastname;
	private String _street;
	private String _city;
	private String _country;
	
    User (String firstname, String lastname, String street, String city, String country) {
        _id = ++_IDCounter;
        _firstname = firstname;
        _lastname = lastname;
        _street = street;
        _city = city;
        _country = country;
    }

    public abstract Integer getLendingPeriod(RentObject ro);
	public abstract Integer getLendingPrice();
	public abstract Integer getMaxExtensions();

    public Integer getID() {
        return _id;
    }

    public void rent(RentObject ro) {
        new Rent(ro, this);
    }

    public void reserve(RentObject ro) {
        new Reservation(ro, this);
    }

    public void extend(RentObject ro) {
        Rent.extend(ro, this);
    }

    public String getAllRents() {
        return Rent.getAllRentsByUser(this);
    }

    public String getAllReservations() {
        return Reservation.getAllReservationsByUser(this);
    }

    public String getAddress() {
        return _street + ", " + _city + ", " + _country;
    }

    public String toString() {
        return _firstname + " " + _lastname + " (" + _id + ")";
    }
}
