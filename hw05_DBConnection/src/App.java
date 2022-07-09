public class App {
    public static void main(String[] args) throws Exception {
        DBFactory dbf = new DBFactory();

        for (int i=0; i < 7; i++) {
            try {
                DBConnection dbc = dbf.createDBConnection();
                if (i % 2 != 0) {
                    dbc.close(dbf);
                    System.out.println(dbc.getLastUsed());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
