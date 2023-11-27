
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

    public class MeatDistributionAppFX extends Application {

        private ArrayList<House> houses;
        private MeatDistributionSystem meatDistributionSystem;
        private TableView<DistributionData> tableView;
        private TextField addressField;
        private TextField ownerNameField;
        private TextField meatQuantityField;
        private TextField sacrifiedField;
        private TextField meatTypeField;


        public static void main(String[] args) {
            launch(args);
        }

        @Override

        public void start(Stage primaryStage) {
            primaryStage.setTitle("Meat Distribution App");

            // Initialize houses and meat distribution system
            houses = createDummyHouses();
            meatDistributionSystem = new MeatDistributionSystem(houses);

            // Create UI elements
            Button distributeButton = new Button("Distribute Meat");
            distributeButton.setOnAction(event -> {
                meatDistributionSystem.distributeMeat();
                updateTableView();
                meatDistributionSystem.printHouses();
            });

            tableView = createTableView();
            addressField = new TextField();
            addressField.setPromptText("House Address");
            ownerNameField = new TextField();
            ownerNameField.setPromptText("Owner Name");
            meatQuantityField = new TextField();
            meatQuantityField.setPromptText("Meat Quantity");
            sacrifiedField = new TextField();
            sacrifiedField.setPromptText("Sacrified (true/false)");
            meatTypeField = new TextField();
            meatTypeField.setPromptText("Meat Type");

            // Create "Add House" button
            Button addButton = new Button("Add House");
            addButton.setOnAction(event -> addHouse());

            // Set up layout
            VBox layout = new VBox(10);
            layout.getChildren().addAll(
                    distributeButton,
                    tableView,
                    addressField,
                    ownerNameField,
                    meatQuantityField,
                    sacrifiedField,
                    meatTypeField,
                    addButton
            );
            meatTypeField.disableProperty().bind(
                    Bindings.createBooleanBinding(
                            () -> sacrifiedField.getText().equalsIgnoreCase("false"),
                            sacrifiedField.textProperty()
                    )
            );

            // Set up scene
            Scene scene = new Scene(layout, 600, 400);
            primaryStage.setScene(scene);

            // Show the stage
            primaryStage.show();

            // Update table view initially
            updateTableView();
        }


        private void clearInputFields() {
            addressField.clear();
            ownerNameField.clear();
            meatQuantityField.clear();
            sacrifiedField.clear();
            meatTypeField.clear();
        }

        private void addHouse() {
            try {
                String address = addressField.getText();
                String ownerName = ownerNameField.getText();
                double meatQuantity = Double.parseDouble(meatQuantityField.getText());
                boolean sacrified = Boolean.parseBoolean(sacrifiedField.getText());

                MeatType meatType = null;
                if (sacrified) {
                    String meatTypeStr = meatTypeField.getText();
                    meatType = MeatType.valueOf(meatTypeStr.toUpperCase());
                }

                House newHouse = new House(address, ownerName, sacrified ? new Meat(meatQuantity, meatType) : new Meat(0.0, null), sacrified);
                houses.add(newHouse);

                // Update the TableView and clear input fields
                updateTableView();
                clearInputFields();
            } catch (IllegalArgumentException e) {
                // Handle input validation errors (e.g., non-numeric meat quantity)
                System.out.println("Invalid input. Please check your input values.");
            }
        }

    }

        private TableView<DistributionData> createTableView() {
            TableView<DistributionData> tableView = new TableView<>();

            TableColumn<DistributionData, String> addressCol = new TableColumn<>("House Address");
            addressCol.setCellValueFactory(new PropertyValueFactory<>("houseAddress"));

            TableColumn<DistributionData, String> ownerCol = new TableColumn<>("Owner Name");
            ownerCol.setCellValueFactory(new PropertyValueFactory<>("ownerName"));

            TableColumn<DistributionData, String> quantityCol = new TableColumn<>("Meat Quantity");
            quantityCol.setCellValueFactory(new PropertyValueFactory<>("meatQuantity"));

            TableColumn<DistributionData, String> sacrifiedCol = new TableColumn<>("Sacrified");
            sacrifiedCol.setCellValueFactory(new PropertyValueFactory<>("sacrified"));

            TableColumn<DistributionData, String> meatTypeCol = new TableColumn<>("Meat Type");
            meatTypeCol.setCellValueFactory(new PropertyValueFactory<>("meatType"));

            tableView.getColumns().addAll(addressCol, ownerCol, quantityCol, sacrifiedCol, meatTypeCol);

            return tableView;
        }

        private void updateTableView() {
            ObservableList<DistributionData> data = FXCollections.observableArrayList();
            for (House house : houses) {
                String meatTypeString = "null";
                if (house.isSacrified()) {
                    meatTypeString = house.getMeat().getMeatType().toString();
                }
                data.add(new DistributionData(
                        house.getAddress(),
                        house.getOwnerName(),
                        String.valueOf(house.getMeat().getQuantity()),
                        String.valueOf(house.isSacrified()),
                        meatTypeString
                ));
            }
            tableView.setItems(data);
        }





        private ArrayList<House> createDummyHouses() {
            ArrayList<House> dummyHouses = new ArrayList<>();
            // Create dummy houses here
            return dummyHouses;
        }
    }

