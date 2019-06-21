import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ColoePane extends HBox{
	int count = 0;
	TextPane color = new TextPane("");		//颜色指示
	TextPane counter = new TextPane("");	//连击计数器
	Button[] rec = new Button[3];
	int ans;
	int[] a = new int[3];	//答案数组
	static int[] r = new int[3];
	static int[] g = new int[3];
	static int[] b = new int[3];
	ColoePane(){

				
		color.getText().setFont(Font.font("仿宋",FontWeight.SEMI_BOLD,FontPosture.REGULAR,40));
		color.setPadding(new Insets(50));
		
		counter.setPadding(new Insets(10));
		counter.setAlignment(Pos.BASELINE_RIGHT);
		
		for(int i = 0;i < 3;i++) {		//设置按钮
			rec[i] = new Button();
			rec[i].setMinHeight(70);
			rec[i].setMinWidth(70);
			rec[i].setOnAction(e->{
				if(e.getSource() == rec[ans]) {
					showTimedDialog(true);
					count++;
					setColor();
				}
				else {
					showTimedDialog(false);
					count=0;
					setColor();
				}	
			});
		}
		
		
		this.getChildren().addAll(rec);
		this.setSpacing(40);
		this.setAlignment(Pos.CENTER);
	}
	
	public static void RadomRGB() {
		for(int i = 0;i<3;i++) {
			r[i] = (int)(1+Math.random()*(225-1+1));
			g[i] = (int)(1+Math.random()*(225-1+1));
			b[i] = (int)(1+Math.random()*(225-1+1));
		}
			
	}
	public  int[] setColor() {
		ans = (int)(0+Math.random()*(3-1+1));
		
		RadomRGB();
		a[0] = r[ans];
		a[1] = g[ans];
		a[2] = b[ans];
		
		color.setText("( "+a[0]+"，"+a[1]+"，"+a[2]+" )");
		counter.setText("Combo: "+ count);
		
//		System.out.println(""+ans);
		for(int i = 0;i < 3;i++) {
			rec[i].setStyle("-fx-background-color: rgb("+r[i]+","+g[i]+","+b[i]+")");
//			rec[i].setFill(Color.rgb(r, g, b));
		}
		return a;
	}
	
	public static void showTimedDialog(boolean tof) {
		int time = 2000;
		String message;
		Image checkT = new Image("file:img/r.png");		
		Image checkF = new Image("file:img/w.png");	
		ImageView check;
		Stage popup = new Stage();
		if(tof) {
			popup.getIcons().add(new Image("file:img/r.png"));
			check = new ImageView(checkT);
			message = "选对啦！！！";
		}else {
			popup.getIcons().add(new Image("file:img/w.png"));
			check = new ImageView(checkF);
			message = "选错啦！！！";
		}
		
		
		popup.setAlwaysOnTop(true);
		popup.initModality(Modality.APPLICATION_MODAL);
		
		VBox root = new VBox();
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setSpacing(20);
		Label lable = new Label(message);
		lable.setFont(new Font(20));
		root.getChildren().addAll(check,lable);
		Scene scene = new Scene(root);
		popup.setScene(scene);
		popup.setTitle("");
		popup.show();
 
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(time);
				if (popup.isShowing()) {
					Platform.runLater(() -> popup.close());
				}
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
	
	
	public TextPane getColor() {
		return color;
	}

	public int getCount() {
		return count;
	}
	public TextPane getCounter() {
		return counter;
	}
	
}
