import java.util.Arrays;

public class DiscreteSquareGrid {
    private static int[] count;
    private static Grid grid;
    private static TowerSampler towerSampler;
    private static Turtle turtle;

    public static void main(String[] args) {
        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        count = new int[w*h];

        grid = new Grid(w,h,true);
        towerSampler = new TowerSampler(grid);

        turtle = new Turtle(grid.getState(1));
        //count[turtle.getCurrentState().getValue()]++;
        for(int i = 0; i < 1000000; i++) {
            step();
            count[turtle.getCurrentState().getValue()-1]++;
        }
        System.out.println("Q1: " + Arrays.toString(count));

        //////////////////////////////////////////////////////

        for(int r = 0; r < 10; r++) {

            grid = new Grid(w, h, false);
            towerSampler = new TowerSampler(grid);

            count = new int[9];
            turtle = new Turtle(grid.getState(1));
            for(int i = 0; i < 1000000; i++) {
                step();
                count[turtle.getCurrentState().getValue() - 1]++;
            }
            System.out.println("Q2/4: " + Arrays.toString(count));

        //////////////////////////////////////////////////////

            count = new int[9];
            for(int i = 0; i < 10000; i++) {
                turtle = new Turtle(grid.getState(1));
                for(int x = 0; x < 3; x++) {
                    step();
                    if(x == 2) {
                        count[turtle.getCurrentState().getValue() - 1]++;
                    }
                }
            }
            System.out.println("Q3: " + Arrays.toString(count));

        }

    }

    private static void step() {
        turtle.setCurrentState(towerSampler.discreteSample(turtle.getCurrentState()));
    }
}
