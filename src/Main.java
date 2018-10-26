import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.util.List;


public class Main {
    public static void main(String args[]) {
        List<Double> independent = new Simulator(0.022, 50, 2000, 0, false).simulate();
        List<Double> dependent = new Simulator(0.00442, 50, 2000, 3, true).simulate();

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion", independent, dependent);
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        // INDEPENDENT: 0.022
        // DEPENDENT: 0.00442

    }
}
