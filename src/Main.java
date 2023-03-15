import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.pow;
public class Main extends JFrame {
    private final TextFieldWithPretunedSize radius = new TextFieldWithPretunedSize();
    private final TextFieldWithPretunedSize circleArea = new TextFieldWithPretunedSize();
    public Main() {
        setUpWindow();
        GridBagConstraints c = new GridBagConstraints();
        addInputs(c);
        addCalculateButton(c);
        addOutputs(c);
        revalidate();
    }
    private void setUpWindow() {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Площа кола калькулятор");
        setLayout(new GridBagLayout());
    }
    private void addInputs(GridBagConstraints c) {
        JPanel inputsContainer = new JPanel();
        inputsContainer.setLayout(new BoxLayout(inputsContainer, BoxLayout.Y_AXIS));
        inputsContainer.add(new JLabel("Радіус"));
        inputsContainer.add(radius);
        add(inputsContainer, c);
    }
    private void addOutputs(GridBagConstraints c) {
        JPanel outputsContainer = new JPanel();
        outputsContainer.setLayout(new BoxLayout(outputsContainer, BoxLayout.Y_AXIS));
        outputsContainer.add(new JLabel("Площа кола"));
        outputsContainer.add(circleArea);
        add(outputsContainer, c);
    }
    private void addCalculateButton(GridBagConstraints c) {
        JButton calculateButton = new JButton("Обчислити");
        calculateButton.setPreferredSize(new Dimension(100, 30));
        calculateButton.addMouseListener(getClickListener());
        c.insets = new Insets(0, 10, 0, 5);
        add(calculateButton, c);
    }
    private MouseListener getClickListener() {
        return new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                double radiusValue = Double.parseDouble(radius.getText());
                double circleAreaValue = Math.PI * pow(radiusValue, 2);
                circleArea.setText(Double.toString(circleAreaValue));
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        };
    }
    private static class TextFieldWithPretunedSize extends JTextField {
        public TextFieldWithPretunedSize() {
            setPreferredSize(new Dimension(150, 35));
        }
    }
}