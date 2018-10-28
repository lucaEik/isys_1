/**
 * This class represents a person among other people in a group. A person can be in Susceptionstate or can have
 * a Opinion A.
 */
public class Person {


    /**
     * Opinion of the person, true if this person has opinion A
     */
    private boolean hasOpinionA;

    /**
     * Person which made this person interested in opinion A
     */
    private Person inducer;

    /**
     * Boolean given by Susceptionstate of person
     */
    public boolean susceptionState;

    /**
     * Constant duration of susception state
     */
    private static final Integer SusceptibleStateDuration = 5;

    /**
     * Set duration given by constant
     */
    private Integer susceptibleDurationLeft = SusceptibleStateDuration;

    /**
     * Constructor of a person
     * @param hasOpinionA Boolean to set Opinion A
     */
    public Person(boolean hasOpinionA) {
        this.hasOpinionA = hasOpinionA;
    }

    /**
     * Check if person has opinion A
     * @return Boolean depending on the opinion of the persion
     */
    public boolean getHasOpinionA() {
        return this.hasOpinionA;
    }

    /**
     * Change Opinion of person
     */
    public void changeOpinion() {
        this.hasOpinionA = true;
    }

    /**
     * Updates the state of Susception of the Person.
     */
    public void updateSusceptionState() {

        // Decrement Duration of Susception state if duration is not 1
        if ( this.susceptibleDurationLeft != 1 ) {
            susceptibleDurationLeft--;
        }

        // Set back otherwise
        else {
           setBackSusception();
        }
    }

    /**
     * Set back Susception state of user.
     */
    public void setBackSusception() {
        susceptibleDurationLeft = 5;
        susceptionState = false;
        inducer = null;
    }

    /**
     * Checks if two Persons have met each other recently and are receptive for the new opinion
     * @param other Person to check if person is the inducer or this person is the inducer of other person
     * @return a Boolean which depends on if this or other person is the inducer of this person; True if this person is
     *         the inducer of the other person or the other person is the inducer of this person, false if not
     */
    public boolean checkInducerMet(Person other) {

        if ( (this.inducer != null && this.inducer == other ) || ( other.inducer != null && other.inducer == this) ) {
            return true;
        }
        return false;
    }

    /**
     * Two people meet each other and influences each other in case of each Opinion and Susception state
     * @param other Person which meets this person.
     */
    public void meetWith(Person other) {

        // Person hasnt met this particular other person during five Days
        if ( !this.checkInducerMet(other) ) {

            // Person is in susception state, other person has Opinion A
            if (this.susceptionState && other.hasOpinionA) {

                // Set Opinion of this Person to A
                this.changeOpinion();

            }

            // Other person is in susception state, this person has Opinion A
            else if (other.susceptionState && this.hasOpinionA) {

                // Set Opinion of other Person to A
                other.changeOpinion();
            }

            // this Person is not in susceptionstate, other person has Opinion A
            else if (!this.susceptionState && other.hasOpinionA) {

                // Set other to inducer and turn on susceptible state of this person
                this.inducer = other;
                this.susceptionState = true;
            }

            // other Person is not in susceptionstate, this person has Opinion A
            else if (!other.susceptionState && this.hasOpinionA) {

                // Set this person to inducer and turn on susceptible state of other person
                other.inducer = this;
                other.susceptionState = true;
            }
        }
    }
}



