import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        /**
         * A Simulator returns a list containing the average percentage of people in a group which changed
         * their opinion based on the required days
         */
        List<Double> independent = new Simulator(0.1, 50, 5000, 10, false).simulate();
        List<Double> dependent = new Simulator(0.1, 50, 5000, 10, true).simulate();

        /**
         * The invokeLater method delays the construction of the LineChart. The LineChart needs
         * the data from simulations as a whole before building the chart.
         */
        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion", independent, dependent);
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}