public class Person {


    private boolean hasOpinionA;

    private Person inducer;

    public boolean getHasOpinionA() {
        return this.hasOpinionA;
    }

    public Person(boolean hasOpinionA) {
        this.hasOpinionA = hasOpinionA;
    }

    public void changeOpinion() {
        this.hasOpinionA = true;
    }

    /** Person meets another person **/
    public void meet(Person other) {
        //TODO: implement meeting another person
    }
}
