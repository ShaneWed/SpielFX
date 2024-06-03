import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View extends Application {
    final int[] DIMENSIONS = new int[]{36, 14};
    Pane basePane = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
        basePane.getChildren().addAll(createBoard(DIMENSIONS));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(basePane);

        scrollPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.D) {
                    scrollPane.setHvalue(scrollPane.getHvalue() + 0.03);
                } else if(keyEvent.getCode() == KeyCode.A) {
                    scrollPane.setHvalue(scrollPane.getHvalue() - 0.03);
                }
            }
        });
        //scrollPane.setPannable(true);

        Pane sideBar = new Pane();
        Background background = new Background(new BackgroundFill(Color.DARKSLATEGREY, CornerRadii.EMPTY, Insets.EMPTY));
        sideBar.setBackground(background);

        SplitPane splitPane = new SplitPane(scrollPane, sideBar);
        splitPane.setDividerPosition(0, 0.8);
        splitPane.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(splitPane, 1920, 1080);
        stage.setTitle("LoremIpsum");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

        Model unit = new Model();
        basePane.getChildren().add(unit.getModel());
    }

    private Parent createBoard(int[] dimensions) {
        Group tiles = new Group();
        for(int x = 0; x < dimensions[0]; x++) {
            for(int y = 0; y < dimensions[1]; y++) {
                tiles.getChildren().add(createTile((x * 50) + 100, (y * 50)));
            }
        }
        return tiles;
    }

    private Rectangle createTile(double x, double y) {
        // Add more variety
        Rectangle newTile = new Rectangle(x, y, 50, 50);
        if(Math.random() * 10 < 7) {
            newTile.setFill(Color.DARKGREEN);
        } else {
            newTile.setFill(Color.DARKKHAKI);
        }
        newTile.setStroke(Color.HOTPINK);

        newTile.setOnDragOver(dragEvent -> newTile.setFill(Color.YELLOWGREEN));

        return newTile;
    }
}
