public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {
        System.out.print("---- Independent Simulation ----" + "\n");
        Group g = new Group(50, 0, 0.3);
        g.iterateSimulateDependent(2000, 0.00442);


        System.out.print("\n"+"---- dependent Simulation ----" + "\n");

        g.iterateSimulateIndependent(2000, 0.00442);

    }
}
