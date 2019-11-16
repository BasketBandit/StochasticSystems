public class Grid {
    private State[][] grid;

    public Grid(int w, int h, boolean even) {
        this.grid = new State[h][w];

        if(even) {
            int count = 0;
            for(int i = h - 1; i > -1; i--) {
                for(int x = 0; x < w; x++) {
                    // All values need to add up to 6. (1/6 etc)
                    switch(++count) {
                        case 1:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 2.5, 2.5, 0, 5);
                            break;
                        case 2:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 2.5, 0, 2.5);
                            break;
                        case 3:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 0, 0, 5);
                            break;
                        case 4:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 2.5, 2.5, 2.5, 2.5);
                            break;
                        case 5:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 2.5, 2.5, 0);
                            break;
                        case 6:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 0, 2.5, 2.5);
                            break;
                        case 7:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 0, 2.5, 2.5, 5);
                            break;
                        case 8:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 0, 2.5, 2.5, 2.5);
                            break;
                        case 9:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 0, 0, 2.5, 5);
                            break;
                    }
                }
            }
        } else {
            int count = 0;
            for(int i = h - 1; i > -1; i--) {
                for(int x = 0; x < w; x++) {
                    // All values need to add up to 6. (1/6 etc)
                    switch(++count) {
                        case 1:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 2.5, 2.5, 0, 5);
                            break;
                        case 2:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 2.5, 0, 2.5);
                            break;
                        case 3:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 0, 0, 5);
                            break;
                        case 4:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 2.5, 2.5, 1.25, 3.75);
                            break;
                        case 5:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 2.5, 1.25, 1.25);
                            break;
                        case 6:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 2.5, 0, 1.25, 3.75);
                            break;
                        case 7:
                            grid[i][x] = new State(count).setDirectionProbabilities(0, 0, 2.5, 1.6666666666, 5.8333333333);
                            break;
                        case 8:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 0, 2.5, 1.6666666666, 3.3333333333);
                            break;
                        case 9:
                            grid[i][x] = new State(count).setDirectionProbabilities(2.5, 0, 0, 1.6666666666, 5.8333333333);
                            break;
                    }
                }
            }
        }
    }

    public State[][] getGrid() {
        return grid;
    }

    public State getState(int value) {
        for(State[] states: grid) {
            for(State state: states) {
                if(state.getValue() == value) {
                    return state;
                }
            }
        }
        throw new IllegalArgumentException("No state with that value exists.");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                stringBuilder.append(grid[i][j].getValue());
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
