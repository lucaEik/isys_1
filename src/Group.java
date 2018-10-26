import java.util.*;

/**
 * This class represents a group of people among which the spreading of opinion A is simulated
 */
public class Group {

    /**
     * The probability factor needed for the simulations
     */
    private double P;

    /**
     * The current day of the simulation
     */
    private int day;

    /**
     * The Groups people
     */
    private List<Person> people;

    /**
     * Creates a new Instance of the Group class
     * @param groupSize The amount of people in this group
     * @param opinionAPopularity The amount of people who hold opinion A at the beginning of the simulation
     * @param p the Probability for two people to meet each other or the probability for a person to change to opinion
     *          autonomously, depending on if the spreading of a simulation happens dependently or independently.
     */
    public Group(int groupSize, int opinionAPopularity, double p) { // Constructor for Simulation
        this.P = p;
        this.day = 0;
        this.people = new ArrayList<>();
        for (int i = 0; i < groupSize - opinionAPopularity; i++) {
            this.people.add(new Person(false ));
        }
        for (int i = 0; i < opinionAPopularity; i++) {
            this.people.add(new Person(true));
        }
    }


    /**
     * Simulates the independent spreading of opinion A in this group
     * @return A List containing the percentage of people who have opinion A for every day of the simulation
     */
    public List<Double> simulateIndependent() {
        List<Double> aPercentage = new ArrayList<>();
        while (opinionASpreading() < this.people.size()) {
            for (Person person : this.people) {

                if (Math.random() < P) {
                    person.changeOpinion();

                }
            }
            aPercentage.add((double)opinionASpreading() / this.people.size());
        }
        return aPercentage;
    }

    /**
     * Meet-Matrix
     * x = meet
     * ______________________
     * 0 1 2 3 4 5 6 7 8 9
     * 1 - x x x x x x x x
     * 2 - - x x x x x x x
     * 3 - - - x x x x x x
     * 4 - - - - x x x x x
     * 5 - - - - - x x x x
     * 6 - - - - - - x x x
     * 7 - - - - - - - x x
     * 8 - - - - - - - - x
     * 9 - - - - - - - - -
     *
     * Every Person meets other person exactly once a day by chance (P).
     * Simulates the dependent spreading of opinion A in this group.
     * @return A List containing the percentage of people who have opinion A for every day of the simulation
     */
    public List<Double> simulateDependent() {
        int counter = 1;
        List<Double> aPercentage = new ArrayList<>();
        while (opinionASpreading() < this.people.size()) {
            for ( int i = 0; i < this.people.size(); i++) {
                for ( int j = counter; j < this.people.size(); j++) {
                    if (Math.random() < P) {
                        people.get(i).meetWith(people.get(j));
                    }
                }
                // In Case this Person is susceptible, update Susception state
                if ( people.get(i).susceptionState ) {
                    people.get(i).updateSusceptionState();
                }
                counter++;
            }
            counter = 1;
            aPercentage.add((double)opinionASpreading() / this.people.size());
        }
        return aPercentage;
    }


    /**
     * Detetermines the Amount of people in this group who have opinion a
     * @return The amount of people in this group who have opinion A
     */
    private int opinionASpreading() {
        int sum = 0;
        for (Person person : this.people) {
            if (person.getHasOpinionA()) {
                sum++;
            }
        }
        return sum;
    }
}
