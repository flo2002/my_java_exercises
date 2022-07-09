package simpleMUD;

public enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public Direction getOppositeOf(Direction d) {
        switch (d) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            case EAST:
                return WEST;
            default:
                return null;
        }
    }

    public Integer[] getIntegerValues() {
        switch (this) {
            case NORTH:
                return new Integer[] {-1, 0};
            case SOUTH:
                return new Integer[] {1, 0};
            case WEST:
                return new Integer[] {0, -1};
            case EAST:
                return new Integer[] {0, 1};
            default:
                return new Integer[] {0, 0};
        }
    }
}