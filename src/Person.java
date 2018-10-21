import java.util.logging.Logger;

public class Person {

    private int tempID; // ID to check matrix

    private boolean hasOpinionA;

    private Person inducer;

    public boolean susceptionState;  // Empfänglich

    private static final Integer SusceptibleStateDuration = 5;

    private Integer susceptibleDurationLeft = SusceptibleStateDuration;


    public boolean getHasOpinionA() {
        return this.hasOpinionA;
    }

    public Person(boolean hasOpinionA, int tempID) {
        this.hasOpinionA = hasOpinionA;
        this.tempID = tempID;
    }

    public void changeOpinion() {
        this.hasOpinionA = true;
    }


    // update Susception state
    public void updateSusceptionState() {
       // System.out.print( this + ": Days Left: " + this.susceptibleDurationLeft  + "\n");
        if ( this.susceptibleDurationLeft != 1 ) {
            susceptibleDurationLeft--;
        }
        else {
           setBackSusception();
        }
    }

    // reset Susception state
    public void setBackSusception() {
        susceptibleDurationLeft = 5;
        susceptionState = false;
        inducer = null;
    }

    public boolean checkInducerMet(Person other) {

        if (this.inducer != null && this.inducer == other) {
            return true;
        }
        return false;
    }

    /** Person meets another person **/
    public void meetWith(Person other, double p) {
       // System.out.print(this + " has Opinion A: " +this.hasOpinionA +" meets " + other + " has Opinion A: " + other.hasOpinionA + "\n");

        // Person hasnt met other person during five Days
        if ( !this.checkInducerMet(other) ) {

            // Person has Opinion A, other person has been turned susceptible by another Person
            if (this.susceptionState && other.hasOpinionA) {

                // Set Opinion of other Person to A by chance
                if (Math.random() < p) {
                    this.changeOpinion();
                }

                // Person has Opinion A, other person has not been turned susceptible till now
            } else if (!this.susceptionState && other.hasOpinionA) {

                // Set other to inducer and turn on susceptible state of this person
                this.inducer = other;
                this.susceptionState = true;
            }
        }
    }

    public String toString() {
        return "Person[" + this.tempID + "]";
    }
}



