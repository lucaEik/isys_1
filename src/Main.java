public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {

        Group g = new Group();

        System.out.print("---- Independent Simulation ----" + "\n");
        //new Group(2000, 0.022).simulateIndependent();
        //g.iterateSimulateIndependent(2000, 0.022);
        new Simulator(0.022, 50, 2000, 0, false).simulate();
        System.out.print("\n"+"---- dependent Simulation ----" + "\n");
        new Simulator(0.00442, 50, 2000, 3, true).simulate();
        //g.iterateSimulateDependent(2000, 0.00442);

    }
}
