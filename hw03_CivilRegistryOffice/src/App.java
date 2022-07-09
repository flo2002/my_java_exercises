public class App {
    public static void main(String[] args) throws Exception {
        Person donald = new Person("Donald", "Duck", Gender.male, "1.1.1980");
        Person daisy = new Person("Daisy", "Queen", Gender.female, "10.1.1982");
        Person witness1 = new Person("Steven", "Palmer", Gender.male, "5.5.1981");
        Person witness2 = new Person("Evelyn", "Gines", Gender.female, "7.7.1983");

        donald.marry(daisy, witness1);
        daisy.marry(donald, witness2);

        System.out.println(Married.print());

        donald.divorce("Vernachlässigung");
        daisy.divorce("Vernachlässigung");

        System.out.println(Divorce.print());
    }
}
