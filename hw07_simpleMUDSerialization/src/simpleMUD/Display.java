package simpleMUD;

public class Display {

    /*public void print(Level lvl) {
        System.out.println("Current Level: ");
        for (int i=0; i<lvl.getCells().length; i++) {
            for (int j=0; j<lvl.getCells().length; j++) {
                System.out.println("Cell: " + lvl.getCells()[i][j].getID() + ", " + lvl.getCells()[i][j].getShortDescription());
                System.out.println(lvl.getCells()[i][j].getFullDescription() + "\n");
                System.out.println("North:" + lvl.getCells()[i][j].getNeighbor(Direction.NORTH, lvl).getShortDescription());
                System.out.println("East:" + lvl.getCells()[i][j].getNeighbor(Direction.EAST, lvl).getShortDescription());
                System.out.println("South:" + lvl.getCells()[i][j].getNeighbor(Direction.SOUTH, lvl).getShortDescription());
                System.out.println("West:" + lvl.getCells()[i][j].getNeighbor(Direction.WEST, lvl).getShortDescription());
                System.out.println("-------------------------------------------------------");
            }
        }
    }*/

    public void prettyPrint(Player player, Game game, Level lvl) {
        String[][] frame = new String[lvl.getCells().length][lvl.getCells()[0].length];

        for (int i=0; i<lvl.getCells().length; i++) {
            for (int j=0; j<lvl.getCells()[0].length; j++) {
                switch(lvl.getCells()[i][j].getCellStatus()) {
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
