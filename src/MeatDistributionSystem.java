import java.util.ArrayList;
public class MeatDistributionSystem {
    private ArrayList<House> houses;
    private double totalDistributeAbleMeat=0;

    MeatDistributionSystem(ArrayList<House> houses) {
        this.houses = houses;
    }
    public void distributeMeat() {
        for (House h : houses) {
            if (h.sacrified()) {
                // Check if the house has meat to distribute
                if (h.getMeat().getMeat() > 0) {
                    double totalMeat = h.getMeat().getMeat();
                    double distributeAbleMeat = totalMeat / 3;
                    double remainedMeat=totalMeat-distributeAbleMeat;
                    totalDistributeAbleMeat+=distributeAbleMeat;
                    h.getMeat().setMeat(remainedMeat);

                }
            }
        }
        distributeAmongHouses(totalDistributeAbleMeat);
    }

    public void distributeAmongHouses(double totalDistributeAbleMeat ) {
        double distributeAbleMeat=totalDistributeAbleMeat/housesNotSacrified();
        for(House house:houses){
            if(!house.sacrified() &&house.getMeat().getMeat()==0){
                house.getMeat().setMeat(distributeAbleMeat);
            }
        }
    }
    public int housesNotSacrified(){
        int housesWithNoMeat=0;
        for (House house:houses) {
            if (!house.sacrified() &&house.getMeat().getMeat()==0) {
                housesWithNoMeat++;
            }
        }
        return housesWithNoMeat;
    }

    public void printHouses(){
        for (House h:houses
        ) {
            System.out.println("House Address: "+h.getAddress());
            System.out.println("Owner Name: "+h.getOwnerName());
            System.out.println("Meat Quantity: "+h.getMeat().getMeat());
            System.out.println("Sacrified : "+(h.isSacrified()?"Yes":"No"));
            System.out.println("------------------------");

        }
    }
}
