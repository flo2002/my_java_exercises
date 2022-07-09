import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String _firstname;
    private String _lastname;
    private LocalDate _birthday;
    private Gender _gender;
    private String _maidenname;
    private Boolean _ageConsentStatement = false;   //default

    Person (String firstname, String lastname, Gender gender, String birthday) {
        _firstname = firstname;
        _lastname = lastname;
        _gender = gender;
        _maidenname = _lastname;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        _birthday = LocalDate.parse(birthday, formatter);;
    }

    public String getName() {
        return _firstname + " " + _lastname;
    }

    public Boolean isDifferentGender(Person husband) {
        if (!this._gender.equals(husband._gender)) {
            return true;
        }
        return false;
    }

    private Boolean isAdult(Person person) {
        if (person._birthday.isAfter(LocalDate.now().plusYears(18))) {
            return true;
        } else {
            if (person._ageConsentStatement) {
                return true;
            }
        }
        return false;
    }

    public Boolean isMarried(Person husband) {
        if (Married.getHusband(this) != null) {
            return true;
        }
        return false;
    }

    public Boolean isSamePerson(Person person) {
        if (this.equals(person)) {
            return true;
        }
        return false;
    }

    public Boolean isAllowedToMarry(Person husband) {
        if (isAdult(husband) 
            && isAdult(this) 
            && isDifferentGender(husband) 
            && !isMarried(husband) 
            && !isSamePerson(husband)) {
            return true;
        }
        return false;
    }

    public void marry(Person husband, Person witness) {
        if (isAllowedToMarry(husband)) {
            if (isAdult(witness)) {
                Married.addMarried(new Married(this, husband, witness, LocalDate.now()));
            }
        }
    }

    public void divorce(String reason) {
        Person husband = Married.getHusband(this);
        Person witness = Married.getWitness(this);
        LocalDate marriedDate = Married.getMarriedDate(this);

        Married.removeMarried(new Married(this, husband, witness, marriedDate));
        Divorce.addDivorce(new Divorce(this, husband, reason, LocalDate.now()));
    }
}
