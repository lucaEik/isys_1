import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Average days for People to change Opinion");
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });

        Group g = new Group();

        System.out.print("---- Independent Simulation ----" + "\n");

        //g.iterateSimulateIndependent(20, 0.0222);


        System.out.print("\n"+"---- dependent Simulation ----" + "\n");

       // g.iterateSimulateDependent(20, 0.00442);

    }
}
