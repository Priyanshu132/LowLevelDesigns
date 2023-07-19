public class Cell {

    private Integer startPosition;
    private Integer endPosition;

    private boolean hasSnakeOrLadder;

    public boolean hasSnakeOrLadder() {
        return hasSnakeOrLadder;
    }

    public void setHasSnakeOrLadder(boolean hasSnakeOrLadder) {
        this.hasSnakeOrLadder = hasSnakeOrLadder;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }
}
