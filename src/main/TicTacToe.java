import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {

		private Button b1;
		
		private TextField t1;
		
		private MenuBar menu;
		
		private EventHandler<ActionEvent> myHandler;
		
		
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("AI TicTacToe");
		
		b1 = new Button("button 1");
		t1 = new TextField();
		
		/*//create an event handler if more than one widget needs same action
		EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				t1.setText("button was pressed!");
			}
		};
		
		//attach the event handler to the button
		b1.setOnAction(myHandler);
		*/
		
		/*//use an anonymous class to attach the event handler to the button
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				t1.setText("button was pressed!");
			}
		});
		*/
		
		//use a lambda expression to attach the event handler to a button
		b1.setOnAction(e->t1.setText("I love this syntax!!!!"));
		
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mOne = new Menu("option 1"); //a menu goes inside a menu bar
		Menu mTwo = new Menu("option 2");
		
		MenuItem iOne = new MenuItem("click me"); //menu items go inside a menu
		
		//event handler for menu item
		iOne.setOnAction(e->t1.setText("menu item was clicked")); 
		
		mOne.getItems().add(iOne); //add menu item to first menu
		
		menu.getMenus().addAll(mOne, mTwo); //add two menus to the menu bar
		
		/* This code demonstrates how to use a GridPane. Might be useful for your project
		
		//event handler is attached to each button in the GridPane
		myHandler = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				System.out.println("button pressed: " + ((Button)e.getSource()).getText());
				Button b1 = (Button)e.getSource();
				b1.setDisable(true);
			}
		};
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		addGrid(grid); //populate the GridPane with buttons
		
		//create a scene with the GridPane as the root
		Scene scene = new Scene(grid,700,700);
		*/
		
		//new scene with root node
		Scene scene = new Scene(new VBox(20,menu,b1,t1), 700,700);
		primaryStage.setScene(scene); //set the scene in the stage
		primaryStage.show(); //make visible to the user
	}
	
	/*
	 * method to populate a GridPane with buttons and attach a handler to each button
	 */
	public void addGrid(GridPane grid) {
		
		for(int x = 0; x<4; x++) {
			
		
			for(int i = 0; i<4; i++) {
				Button b1 = new Button(Integer.toString(i));
				b1.setOnAction(myHandler);
				grid.add(b1, x, i);
				 
			}
		}
	}

}
