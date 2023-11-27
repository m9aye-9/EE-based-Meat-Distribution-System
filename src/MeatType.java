public enum MeatType {
    BEEF(Double.class),MUTTON(Double.class),CAMELMEAT(Double.class);
    private final Class<? extends Number> meatClass;
    MeatType(Class<? extends  Number> meatClass){
        this.meatClass=meatClass;
    }
    public Class<? extends Number> getMeatClass(){
        return meatClass;
    }
}