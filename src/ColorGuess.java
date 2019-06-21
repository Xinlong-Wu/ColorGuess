import javax.swing.ImageIcon;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorGuess extends Application{
	static StackPane sPane;
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage PrimaryStage) throws Exception {
		ColoePane colorPane = new ColoePane();	//三个颜色方块
		colorPane.setPadding(new Insets(60));
		colorPane.setColor();		//设置颜色
		
		
		
		TextPane explane = new TextPane("选择你认为正确的颜色");
		explane.getText().setFont(Font.font("仿宋",FontWeight.SEMI_BOLD,FontPosture.REGULAR,40));
		explane.setPadding(new Insets(60));
		

		
		VBox mainPane = new VBox();
		mainPane.setAlignment(Pos.TOP_CENTER);
		mainPane.setMinSize(400, 500);
		mainPane.getChildren().addAll(colorPane.getCounter(),explane,colorPane.getColor(),colorPane);
		

		sPane = new StackPane();
		sPane.getChildren().add(mainPane);
		Scene scene = new Scene(sPane);
		PrimaryStage.getIcons().add(new Image("file:img/logo.png"));
		PrimaryStage.setTitle("ColorGuess");
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}
}
 