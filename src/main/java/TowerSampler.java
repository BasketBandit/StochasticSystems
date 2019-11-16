import java.util.*;
import java.util.stream.Collectors;

public class TowerSampler {
    private Grid grid;

    private static final State pad = new State(-1).setTransitionProbability(0.0);
    private static final List<Integer> bot = Arrays.asList(1,2,3);
    private static final List<Integer> mid = Arrays.asList(4,5,6);
    private static final List<Integer> top = Arrays.asList(7,8,9);
    private static final List<Integer> edge = Arrays.asList(2,4,6,8);
    private static final List<Integer> topEdge = Arrays.asList(4,6,7,8,9);

    public TowerSampler(Grid grid) {
        this.grid = grid;
    }

    // Implements even probabilities across all states (0.25) (1/n)
    public State discreteSample(State self) {
        List<Double> t = new ArrayList<>(self.getDirectionProbabilities().values());
        // we add the padding state at the base of the tower
        t.add(0, 0.0);

        int index;
        double rand = drawUniformRandom();
        double tot = 0.0;

        for(index = 1; index < t.size()-1; index++) {
            if(t.get(index-1) < rand && rand <= (tot += t.get(index))) {
                break;
            }
        }

        String dir = (String) self.getDirectionProbabilities().keySet().toArray()[index-1];

        State state = null;
        switch(dir) {
            case "up": state = grid.getState(self.getValue()+3);
                break;
            case "right": state = grid.getState(self.getValue()+1);
                break;
            case "down": state = grid.getState(self.getValue()-3);
                break;
            case "left": state = grid.getState(self.getValue()-1);
                break;
            case "self": state = self;
                break;
        }

        return state;
    }

    private double drawUniformRandom() {
        return new Random().nextDouble();
    }

    private double drawExponentialRandom() {
        return -(1.0/4.0)*Math.log(-new Random().nextDouble()+1);
    }
}
