package simpleMUD;

import java.io.*;

public class Loader {
    public static void serialize(Object p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                                        new FileOutputStream(p.getClass().getSimpleName() + ".ser"))) {
            oos.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(Object p) {
        Object obj = new Object();
        try (ObjectInputStream ois = new ObjectInputStream(
                                        new FileInputStream(p.getClass().getSimpleName() + ".ser"))) {
            obj = (Object) ois.readObject();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static void updateNeighbors(Game game, Player p) {
        Level lvl = game.getLevel(p);
        Cell[][] cells = lvl.getCells();

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors(game, p);
            }
        }
    }
}
