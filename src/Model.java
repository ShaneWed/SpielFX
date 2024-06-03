import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Model {
    private int type;
    private Parent model;
    public Model() {
        model = createUnit();
    }

    private Group createUnit() {
        StackPane brigade = new StackPane();
        Text name = new Text("TEST");
        Rectangle unit = new Rectangle(100, 100, 40, 25);
        unit.setFill(Color.AQUAMARINE);
        unit.setArcHeight(10);
        unit.setArcWidth(10);

        //name.addEventHandler(MouseEvent.ANY, e -> brigade.fireEvent(e));

        brigade.getChildren().addAll(unit, name);

        Group brigadeGroup = new Group();
        brigadeGroup.getChildren().add(brigade);

        brigadeGroup.setOnMouseDragged(e -> {
            //System.out.println(System.nanoTime());
            System.out.println("EX: " + e.getSceneX() + " EY: " + e.getSceneY());
            brigadeGroup.setLayoutX(e.getSceneX() - 25);
            brigadeGroup.setLayoutY(e.getSceneY() - 10);
            System.out.println("X: " + brigadeGroup.getLayoutX() + " Y: " + brigadeGroup.getLayoutY());
        });

        return brigadeGroup;
    }

    public Parent getModel() {
        return model;
    }
}
