public class Meat {
    private final MeatType meatType;
    private  Number quantity;


    public Meat(Number quantity,MeatType meatType){
        this.quantity=quantity;
        this.meatType=meatType;
    }
    public Number getQuantity(){
        return quantity;
    }
    public void setQuantity(Number quantity){
        this.quantity=quantity;
    }
    public MeatType getMeatType(){
        return meatType;
    }
    public void validateMeatQuantity(Number quantity) {
        if (quantity != null &&quantity.doubleValue()<0){
            throw new IllegalArgumentException("Meat quantity can not be negative");

        }}



}
