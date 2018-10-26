import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.util.List;


public class Main {
    public static void main(String args[]) {

        List<Double> dataInd = new Simulator(0.02222, 50, 200, 0, false).simulate();
        List<Double> dataD = new Simulator(0.00444, 50, 200, 3, true).simulate();

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion");
            example.setUp(dataInd, dataD);
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(1000, 600);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
