import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Group {
    public Rectangle tile;
    private double x;
    private double y;
    private int terrain;
    private Model unit;
    private boolean isClicked = false;
    private boolean isHovered = false;


    public Tile(double x, double y, int terrain, Model unit) {
        tile = new Rectangle(x, y, 50, 50);
        if(terrain == 0) {
            tile.setFill(Color.DARKGREEN);
        } else {
            tile.setFill(Color.DARKKHAKI);
        }

        this.unit = unit;
        this.isClicked = false;
        this.isHovered = false;
    }

    public void setTerrain(int terrain) {
        this.terrain = terrain;
    }
}
