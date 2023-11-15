

public class House <T extends Meat<? extends Number>>{
    private T meat;
    private String address;
    private String ownerName;

    private   boolean sacrified;
    public House(String address,String ownerName,T meat,boolean sacrified){
        this.address=address;
        this.ownerName=ownerName;
        this.setMeat(meat);
        this.setSacrified(sacrified);

    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public boolean sacrified() {
        return isSacrified();
    }


    public T getMeat() {
        return meat;
    }

    public void setMeat(T meat) {
        this.meat =meat;
    }

    public boolean isSacrified() {
        return sacrified;
    }

    public void setSacrified(boolean sacrified) {
        this.sacrified = sacrified;
    }




}


