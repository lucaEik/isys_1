public class Main {
    //TODO: implement solution for changing values
    public static void main(String args[]) {
        System.out.print("---- Independent Simulation ----" + "\n");
        Group g = new Group(50, 0, 0.4);
        g.simulateIndependent();
        System.out.print("\n"+"---- dependent Simulation ----" + "\n");
        Group g2 = new Group(50, 3, 0.4);
        g2.simulateDependant();
    }
}
