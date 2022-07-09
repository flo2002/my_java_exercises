import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GraphPlotter extends JFrame {
    private final JMenuBar _menuBar;
    private final JMenu _fileMenu;
    private final JMenu _helpMenu;
    private final JMenuItem _addFuncMenuItem;
    private final JMenuItem _exitMenuItem;
    private final JMenuItem _aboutMenuItem;

    private final JPanel _formularPanel;

    private final JPanel _graphOverPanel;
    private final JPanel _graphPanel;
    
    private final JPanel _scalePanel;
    private final JButton _scaleXButton;
    private final JButton _scaleYButton;

    private final Formular _formular;
    private final CoordinateSystem _coordinateSystem;
    private java.util.List<Graph> _graphs = new ArrayList<Graph>();

    public GraphPlotter() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 350));
        setSize(400, 400);

        _menuBar = new JMenuBar();
        _fileMenu = new JMenu("File");
        _addFuncMenuItem = new JMenuItem("Add Function");
        _addFuncMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFunction();
            }
        });
        _exitMenuItem = new JMenuItem("Exit");
        _exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        _fileMenu.add(_addFuncMenuItem);
        _fileMenu.add(_exitMenuItem);
        _helpMenu = new JMenu("Help");
        _aboutMenuItem = new JMenuItem("About");
        _aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GraphPlotter.this, "GraphPlotter\nVersion 1.0\n\nCreated by: Schiemer Florian", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        _helpMenu.add(_aboutMenuItem);
        _menuBar.add(_fileMenu);
        _menuBar.add(_helpMenu);


        _graphPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Graph graph : _graphs) {
                    graph.drawGraph(g);
                }
            }
        };
        _graphPanel.setPreferredSize(new Dimension(300, 300));
        _graphPanel.setBorder(new EmptyBorder(0, 20, 20, 20));
        _graphPanel.setLayout(new OverlayLayout(_graphPanel));
        _coordinateSystem = new CoordinateSystem(10);
        _graphPanel.add(_coordinateSystem);

        _formularPanel = new JPanel();
        _formularPanel.setLayout(new BoxLayout(_formularPanel, BoxLayout.Y_AXIS));
        _formular = new Formular(_coordinateSystem, 300, 300, this);
        _formularPanel.add(_formular);

        _scalePanel = new JPanel();
        _scalePanel.setLayout(new FlowLayout());
        _scaleXButton = new JButton("Scale X");
        _scaleYButton = new JButton("Scale Y");
        _scalePanel.add(_scaleXButton);
        _scalePanel.add(_scaleYButton);

        _graphOverPanel = new JPanel();
        _graphOverPanel.setLayout(new BorderLayout());
        _graphOverPanel.add(_formularPanel, BorderLayout.NORTH);
        _graphOverPanel.add(_graphPanel, BorderLayout.CENTER);
        _graphOverPanel.add(_scalePanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(_menuBar, BorderLayout.NORTH);
        add(_graphOverPanel, BorderLayout.CENTER);

        setVisible(true);

        
        _scaleXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _coordinateSystem.scaleUp();
            }
        });
        _scaleYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _coordinateSystem.scaleDown();
            }
        });
    }

    public void addFunction() {
        Formular formular = new Formular(_coordinateSystem, 300, 300, this);
        _formularPanel.add(formular);
        _formularPanel.revalidate();
        _formularPanel.repaint();
    }

    public void addGraph(Graph graph) {
        if (!_graphs.contains(graph)) {
            _graphs.add(graph);
            _graphPanel.add(graph);
            _graphPanel.revalidate();
            _graphPanel.repaint();
        }
    }
}
