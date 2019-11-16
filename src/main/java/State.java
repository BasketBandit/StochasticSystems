import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class State implements Comparable<State> {
    private ArrayList<State> neighbours = new ArrayList<>();
    private LinkedHashMap<String, Double> directionProbabilities = new LinkedHashMap<>();
    private int value;
    private double transitionProbability = 0.0;

    public State(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public void addNeighbour(State state) {
        neighbours.add(state);
    }

    public ArrayList<State> getNeighbours() {
        return neighbours;
    }

    public double getTransitionProbability() {
        return transitionProbability;
    }

    // Make return type State so we can initialise and set inline.
    public State setTransitionProbability(double transitionProbability) {
        this.transitionProbability = transitionProbability;
        return this;
    }

    public State setDirectionProbabilities(double left, double up, double right, double down, double self) {
        if(left != 0) {
            directionProbabilities.put("left", (0.1)*left);
        }
        if(up != 0) {
            directionProbabilities.put("up", (0.1)*up);
        }
        if(right != 0) {
            directionProbabilities.put("right", (0.1)*right);
        }
        if(down != 0) {
            directionProbabilities.put("down", (0.1)*down);
        }
        if(self != 0) {
            directionProbabilities.put("self", (0.1)*self);
        }
        return this;
    }

    public HashMap<String, Double> getDirectionProbabilities() {
        return directionProbabilities;
    }

    @Override
    public int compareTo(State o) {
        return Double.compare(this.transitionProbability, o.getTransitionProbability());
    }
}
