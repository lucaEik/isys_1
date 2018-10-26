import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Instances of the Simulator type conduct The simulation of the spreading of opinion a one or multiple times and deliver the
 * average results of the simulations. Each simulator can simulate either dependent or independent spreading of opinion A
 */
public class Simulator {

    /**
     * The number of iterations this simulation executes
     */
    private int iterations;

    /**
     * The amount of people who hold opinion A at the start of each simulation
     */
    private int aPopularity;

    /**
     * Either the probability for two people to meet each other or the probability for a person to change to opinion A
     * autonomously, depending on if the spreading of a simulation happens dependently or independently.
     */
    private double P;

    /**
     * The size of the Groups on which the simulation takes place
     */
    private int groupSize;

    /**
     * True if this simulators simulations are dependent, false if not
     */
    private boolean dependent;


    /**
     * Creates a new instance of the Simulator type
     * @param P Either the probability for two people to meet each other or the probability for a person to change to opinion A
     *          autonomously, depending on if the spreading of a simulation happens dependently or independently.
     * @param groupSize The size of the groups in which the simulations take place
     * @param iterations the amount of simulations this simulator conducts
     * @param aPopularity the amount of people who have opinion A at the start of each simulation
     * @param dependent True if this Simulators simulations are dependent, false if not
     */
    public Simulator(double P, int groupSize, int iterations, int aPopularity, boolean dependent) {
        this.aPopularity = aPopularity;
        this.iterations = iterations;
        this.P = P;
        this.groupSize = groupSize;
        this.dependent = dependent;
    }

    /**
     * Simulates the spreading of opinion A. If this Simulators 'dependent'-attribute is true, A's spreading is simulated
     * dependently, if not independently. The simulation is executed multiple, or one time, depending on the 'iterations'
     * attribute. All the simulations results are compiled into one List with the average popularity of opinion A for each
     * day. The average amount of days it took for all people in the groups to get opinion a is printed to the console.
     * @return A List of doubles containing the average percentage of people who have opinion A.
     */
    public List<Double> simulate() {
        List<List<Double>> results = new ArrayList<>();
        Group group;
        List<Double> duration;
        double avgDuration = 0;
        for (int i = 0; i < iterations; i++) {
            group = new Group(this.groupSize, this.aPopularity, this.P);
            if (dependent) {
                duration = group.simulateDependent();
            } else {
                duration = group.simulateIndependent();
            }
            results.add(duration);
            avgDuration += duration.size();
        }

        int longest = 0;
        for (List l : results) {
            if (l.size() > longest) {
                longest = l.size();
            }
        }
        ArrayList<Double> avg = new ArrayList<>();
        for (int i = 0; i < longest; i++) {
            avg.add(0.0);
            for (List<Double> l : results) {
                if (i < l.size()) {
                    avg.set(i, avg.get(i) + l.get(i));
                } else {
                    avg.set(i, avg.get(i) + 1);
                }
            }
            avg.set(i, avg.get(i) / results.size());
        }
        System.out.println("---- " + (this.dependent ? "dependent" : "independent") + " Simulation ----");
        System.out.println("Average Duration for all People to reach opinion a: " + avgDuration / this.iterations);

        return avg;
    }
}
