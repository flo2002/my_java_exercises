package Server;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class List extends JComponent {
    private Server _server;

    public List(Server server) {
        _server = server;
    }
    
    public void drawList() {
        ArrayList<Integer> ids = _server.getIds();
        System.out.println(ids);
        int len = ids.size();
        ArrayList<String> menues = _server.getMenues();

        setLayout(new GridLayout(len, 2));

        for (int i = 0; i < len; i++) {
            JLabel label = new JLabel(ids.get(i).toString());
            add(label);
            JLabel label2 = new JLabel(menues.get(i));
            add(label2);
        }

        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawList();
    }
}
