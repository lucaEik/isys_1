public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {

        Group g = new Group();

        System.out.print("---- Independent Simulation ----" + "\n");

        g.iterateSimulateIndependent(2000, 0.022);


        System.out.print("\n"+"---- dependent Simulation ----" + "\n");

        g.iterateSimulateDependent(2000, 0.00442);

    }
}
