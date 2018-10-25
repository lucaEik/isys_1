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

        if ( (this.inducer != null && this.inducer == other ) || ( other.inducer != null && other.inducer == this) ) {
            return true;
        }
        return false;
    }

    /** Person meets another person **/
    public void meetWith(Person other) {
       // System.out.print(this + " has Opinion A: " +this.hasOpinionA +" meets " + other + " has Opinion A: " + other.hasOpinionA + "\n");

        // Person hasnt met this particular other person during five Days
        if ( !this.checkInducerMet(other) ) {   //if (this.susceptionState() &&

            // Person is in susceptionstate, other person has Opinion A
            if (this.susceptionState && other.hasOpinionA) {
                // Set Opinion of this Person to A
                this.changeOpinion();

            }
            else if (other.susceptionState && this.hasOpinionA) {

                // Set Opinion of this Person to A
                other.changeOpinion();
            }

            // Person is not in susceptionstatehas, other person has Opinion
            else if (!this.susceptionState && other.hasOpinionA) {
                // Set other to inducer and turn on susceptible state of this person
                this.inducer = other;
                this.susceptionState = true;
            }

            else if (!other.susceptionState && this.hasOpinionA) {
                // Set other to inducer and turn on susceptible state of this person
                other.inducer = this;
                other.susceptionState = true;
            }
        }
    }

    public String toString() {
        return "Person[" + this.tempID + "]";
    }
}



