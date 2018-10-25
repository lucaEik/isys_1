import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Main {
    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion");
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        // INDEPENDENT: 0.022
        // DEPENDENT: 0.00442
        
        //g.iterateSimulateIndependent(2000, 0.022);
        new Simulator(0.022, 50, 2000, 0, false).simulate();
        //System.out.print("\n" + "---- dependent Simulation ----" + "\n");
        new Simulator(0.00442, 50, 2000, 3, true).simulate();
        //g.iterateSimulateDependent(2000, 0.00442);

    }
}
