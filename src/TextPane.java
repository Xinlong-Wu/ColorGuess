import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TextPane extends HBox{
	Text text;
	TextPane(){
		text = new Text();
	}
	TextPane(String str){
		text = new Text(str);
		this.getChildren().add(text);
		this.setAlignment(Pos.CENTER);
	}
	public Text getText() {
		return text;
	}
	
	public void setText(String s) {
		// TODO Auto-generated method stub
		text.setText(s);
	}
}
