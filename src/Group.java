import java.util.List;
import java.util.ArrayList;

public class Group {

    private double P;

    private int day;

    private List<Person> people;

    public Group(int groupSize, int opinionAPopularity, double p) {
        this.P = p;
        this.day = 0;
        this.people = new ArrayList<>();
        for (int i = 0; i < groupSize - opinionAPopularity; i++) {
            this.people.add(new Person(false));
        }
        for (int i = 0; i < opinionAPopularity; i++) {
            this.people.add(new Person(true));
        }
    }

    public void simulateIndependent() {
        while (finished() < this.people.size()) {
            for (Person person : this.people) {
                if (Math.random() < P) {
                    person.changeOpinion();
                }
            }
            System.out.println("Day " + this.day + ": " + finished() + " / " + this.people.size());
            day++;
        }
    }

    public void simulateDependant() {
        //TODO implement independent simulation
    }

    private boolean isFinished() {
        for (Person person : this.people) {
            if (!person.getHasOpinionA()) {
                return false;
            }
        }
        return true;
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
