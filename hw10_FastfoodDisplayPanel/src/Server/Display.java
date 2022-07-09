package Server;

import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {
    private Server _server;
    private List _list;

    private JPanel _panel;

    public Display(Server server) {
        _server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);

        _panel = new JPanel();
        _panel.setLayout(new GridLayout(2, 2));
        JLabel id_label = new JLabel("ID ");
        JLabel menue_label = new JLabel("Menu ");
        _panel.add(id_label);
        _panel.add(menue_label);

        _list = new List(_server);
        _panel.add(_list);


        add(_panel);
        setVisible(true);
    }
}
