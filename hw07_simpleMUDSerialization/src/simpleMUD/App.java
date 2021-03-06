package simpleMUD;

import java.io.Serializable;
import java.util.logging.Level;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App implements NativeKeyListener, Serializable {
    public Player _flo;
    public Display _display;
    public Game _game;

    public App() {
        _flo = new Player("flo");
        _display = new Display();
        _game = new Game(_flo);
        _flo.spawn(_game);
    }

    public static void main(String[] args) throws Exception {
        // set logger level of jnativehook to Warning
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.exit(-1);
        }
        GlobalScreen.addNativeKeyListener(new App());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        System.out.println("\n\n\n\n\n\n\n");

        switch (NativeKeyEvent.getKeyText(nativeEvent.getKeyCode())) {
            case "W":
            case "w":
                _flo.move(Direction.NORTH, _game, _flo);
                break;
            case "A":
            case "a":
                _flo.move(Direction.WEST, _game, _flo);
                break;
            case "S":
            case "s":
                _flo.move(Direction.SOUTH, _game, _flo);
                break;
            case "D":
            case "d":
                _flo.move(Direction.EAST, _game, _flo);
                break;
            case "F":
            case "f":
                Loader.serialize(_game);
                //Loader.serialize(_flo);
                //Loader.serialize(_game.getLevel(_flo));
                System.exit(0);
                break;
            case "G":
            case "g":
                _game = (Game) Loader.deserialize(_game);
                _flo = _game.getPlayers()[0];

                /*Loader.updateNeighbors(_game, _flo);
                _flo = (Player) Loader.deserialize(_flo);
                for (Cell c : _game.getLevel(_flo).getCells()[0]) {
                    System.out.println(c.getLocation()[0] + " " + c.getLocation()[1]);
                }*/
                break;
            default:
                System.out.println("Invalid key! Please use wasd.");
        }

        _display.prettyPrint(_flo, _game, _game.getLevel(_flo));
        System.out.println("Items: " + _flo.getPoints() + " / " + _flo.getMaxPoints());
        System.out.println("??...Player, *...Key, |||...Door, i...Item");

        //_display.print();
        //System.out.println(NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {

    }
}
