
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Formular extends JComponent {
    private final GraphPlotter _graphPlotter;
    private final CoordinateSystem _coordinateSystem;

    private final JLabel _FormularLabel;
    private final JLabel _AformularLabel;
    private final JLabel _BformularLabel;
    private final JTextField _AformularTextField;
    private final JTextField _BformularTextField;
    private final JTextField _CformularTextField;
    private final JButton _PlotButton;

    public Formular(CoordinateSystem coordinateSystem, int preferredX, int preferredY, GraphPlotter graphPlotter) {
        _coordinateSystem = coordinateSystem;
        setLayout(new FlowLayout());

        _graphPlotter = graphPlotter;

        _FormularLabel = new JLabel("f(x) = ");
        _AformularLabel = new JLabel("x² + ");
        _BformularLabel = new JLabel("x + ");
        _AformularTextField = new JTextField(3);
        _BformularTextField = new JTextField(3);
        _CformularTextField = new JTextField(3);
        _PlotButton = new JButton("Plot");

        add(_FormularLabel);
        add(_AformularTextField);
        add(_AformularLabel);
        add(_BformularTextField);
        add(_BformularLabel);
        add(_CformularTextField);
        add(_PlotButton);

        _PlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_AformularTextField.getText().isEmpty() || _BformularTextField.getText().isEmpty() || _CformularTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int a = Integer.parseInt(_AformularTextField.getText());
                    int b = Integer.parseInt(_BformularTextField.getText());
                    int c = Integer.parseInt(_CformularTextField.getText());
                    _graphPlotter.addGraph(new Graph(_coordinateSystem, 300, 300, a, b, c));
                }
            }
        });
    }
}
