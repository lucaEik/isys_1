import java.util.*;

public class Group {

    public static ArrayList chartData = new ArrayList();
    private double P;

    private int day;

    private List<Person> people;

    public Group(int groupSize, int opinionAPopularity, double p) { // Constructor for Simulation
        this.P = p;
        this.day = 0;
        this.people = new ArrayList<>();
        for (int i = 0; i < groupSize - opinionAPopularity; i++) {
            this.people.add(new Person(false, i+1));
        }
        for (int i = 0; i < opinionAPopularity; i++) {
            this.people.add(new Person(true, people.size()+1));
        }
    }

    public int simulateIndependent() {

        while (finished() < this.people.size()) {
            for (Person person : this.people) {

                if (Math.random() < P) {
                    person.changeOpinion();

                }
            }


            chartData.add(finished());
            day++;

           // System.out.println("Day " + this.day + ": " + finished() + " / " + this.people.size());
        }

        return day;
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
     *  Every Person meets other person exactly once a day
     **/

    public int simulateDependent() {
        day = 0;
        int counter = 1;
        while (finished() < this.people.size()) {
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

            day++;
            counter = 1;
        }
        return day;
    }

    private int finished() {
        int sum = 0;
        for (Person person : this.people) {
            if (person.getHasOpinionA()) {
                sum++;
            }
        }
        return sum;
    }
}
