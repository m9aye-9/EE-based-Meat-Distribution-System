import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DistributionData {
    private StringProperty houseAddress;
    private StringProperty ownerName;
    private StringProperty meatQuantity;
    private StringProperty sacrified;
    private StringProperty meatType;

    public DistributionData(String houseAddress, String ownerName, String meatQuantity, String sacrified, String meatType) {
        this.houseAddress = new SimpleStringProperty(houseAddress);
        this.ownerName = new SimpleStringProperty(ownerName);
        this.meatQuantity = new SimpleStringProperty(meatQuantity);
        this.sacrified = new SimpleStringProperty(sacrified);
        this.meatType = new SimpleStringProperty(meatType);
    }

    public StringProperty houseAddressProperty() {
        return houseAddress;
    }

    public StringProperty ownerNameProperty() {
        return ownerName;
    }

    public StringProperty meatQuantityProperty() {
        return meatQuantity;
    }

    public StringProperty sacrifiedProperty() {
        return sacrified;
    }

    public StringProperty meatTypeProperty() {
        return meatType;
    }
}
