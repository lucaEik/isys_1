public class Main {
    public static void main(String args[]) {
        //System.out.print("---- Independent Simulation ----" + "\n");
        //new Group(2000, 0.022).simulateIndependent();
        //g.iterateSimulateIndependent(2000, 0.022);
        new Simulator(0.022, 50, 10, 0, false).simulate();
        //System.out.print("\n"+"---- dependent Simulation ----" + "\n");
        new Simulator(0.00442, 50, 10, 3, true).simulate();
        //g.iterateSimulateDependent(2000, 0.00442);
    }
}
