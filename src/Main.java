import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {


        System.out.print("---- Independent Simulation ----" + "\n");
        new Simulator(0.022, 50, 20, 0, false).simulate();
        System.out.print("\n" + "---- dependent Simulation ----" + "\n");
        new Simulator(0.00442, 50, 20, 3, true).simulate();

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion");
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


    }
}

