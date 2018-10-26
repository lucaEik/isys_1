public class Simulator {
    private int iterations;
    private int aPopularity;
    private double P;
    private int groupSize;
    private boolean dependent;

    public Simulator(double P, int groupSize, int iterations, int aPopularity, boolean dependent) {
        this.aPopularity = aPopularity;
        this.iterations = iterations;
        this.P = P;
        this.groupSize = groupSize;
        this.dependent = dependent;
    }

    public void simulate() {
        double avg = 0;
        Group group;
        int duration;
        for (int i = 0; i < iterations; i++) {
            group = new Group(this.groupSize, this.aPopularity, this.P);
            if (dependent) {
                duration = group.simulateDependent();
            } else {
                duration = group.simulateIndependent();
            }
            avg += duration;
            //System.out.println(i + 1 + ". Iteration(Independent): " + duration + " days");
        }
        avg /= iterations;
        System.out.println("Average: " + avg);
    }
}
