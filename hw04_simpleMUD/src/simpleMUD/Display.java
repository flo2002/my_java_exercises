package simpleMUD;

public class Display {

    public void print() throws Exception {
        System.out.println("Current Level: ");
        for (int i=0; i<Level.getCells().length; i++) {
            for (int j=0; j<Level.getCells().length; j++) {
                System.out.println("Cell: " + Level.getCells()[i][j].getID() + ", " + Level.getCells()[i][j].getShortDescription());
                System.out.println(Level.getCells()[i][j].getFullDescription() + "\n");
                System.out.println("North:" + Level.getCells()[i][j].getNeighbor(Direction.NORTH).getShortDescription());
                System.out.println("East:" + Level.getCells()[i][j].getNeighbor(Direction.EAST).getShortDescription());
                System.out.println("South:" + Level.getCells()[i][j].getNeighbor(Direction.SOUTH).getShortDescription());
                System.out.println("West:" + Level.getCells()[i][j].getNeighbor(Direction.WEST).getShortDescription());
                System.out.println("-------------------------------------------------------");
            }
        }
    }

    public void prettyPrint(Player player, Game game) {
        String[][] frame = new String[Level.getCells().length][Level.getCells()[0].length];

        for (int i=0; i<Level.getCells().length; i++) {
            for (int j=0; j<Level.getCells()[0].length; j++) {
                switch(Level.getCells()[i][j].getCellStatus()) {
                    case DEFAULT:
                        frame[i][j] = "  .  ";
                        break;
                    case PLAYER:
                        frame[i][j] = "  °  ";
                        break;
                    case ITEM:
                        frame[i][j] = "  i  ";
                        break;
                    case KEY:
                        frame[i][j] = "  *  ";
                        break;
                    case EMPTY:
                        frame[i][j] = "     ";
                        break;
                    case DOOR:
                        frame[i][j] = " ||| ";
                        break;
                }
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        final PrettyPrinter printer = new PrettyPrinter(System.out);
        printer.print(frame);
    }
}
