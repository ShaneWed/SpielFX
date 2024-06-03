public class Tile {
    private int terrain;
    private Model unit;
    private boolean isClicked = false;
    private boolean isHovered = false;


    public Tile(int terrain, Model unit, boolean isClicked, boolean isHovered) {
        this.terrain = terrain;
        this.unit = unit;
        this.isClicked = isClicked;
        this.isHovered = isHovered;
    }


}
