public class Turtle {
    private State currentState;

    public Turtle(State state) {
        this.currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
