public class Meat<T extends Number> {
    private  T t;

    Meat(T t) {
    try{
    validateMeatQuantity(t);
        this.setT(t);}
    catch (IllegalArgumentException e){
        e.printStackTrace();
    }


    }
    public void validateMeatQuantity(T t){
        if (t != null &&t.doubleValue()<0){
            throw new IllegalArgumentException("Meat quantity can not be negative");

        }}

    public T getT() {
        return t;
    }
    public void setT(Number value) {
        validateMeatQuantity((T) value);
        this.t = (T)value;
    }
}
