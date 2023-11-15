import java.util.ArrayList;
public class MeatDistributionSystem<T extends Meat<? extends Number>> {
    private ArrayList <House<? extends Meat<? extends Number>>> houses;
    private double totalDistributeAbleMeat=0;

    MeatDistributionSystem(ArrayList <House<? extends Meat<? extends Number>>> houses) {
        this.houses = houses;
    }
    public void distributeMeat() {
        for (House<? extends Meat<? extends Number>> h : houses) {
            if (h.sacrified()) {
                // Check if the house has meat to distribute
                if (h.getMeat().getT().doubleValue() > 0) {
                   Number totalMeat =   h.getMeat().getT();
                   double distributeAbleMeat =  totalMeat.doubleValue()/ 3;
                   double remainedMeat=totalMeat.doubleValue()-distributeAbleMeat;
                    totalDistributeAbleMeat+=distributeAbleMeat;
                    h.getMeat().setT(remainedMeat);

                }
            }
        }
        distributeAmongHouses(totalDistributeAbleMeat);
    }

    public void distributeAmongHouses(double totalDistributeAbleMeat ) {
        double distributeAbleMeat=totalDistributeAbleMeat/housesNotSacrified();
        for(House<? extends Meat<? extends Number>>house:houses){
            if(!house.sacrified() &&house.getMeat().getT().doubleValue()==0.0){

                house.getMeat().setT(distributeAbleMeat);
            }
        }
    }
    public int housesNotSacrified(){
        int housesWithNoMeat=0;
        for (House<? extends Meat<? extends Number>> house:houses) {
            if (!house.sacrified() &&house.getMeat().getT().doubleValue()==0.0) {
                housesWithNoMeat++;
            }
        }
        return housesWithNoMeat;
    }

    public void printHouses(){
        for (House<? extends Meat<? extends Number>> h:houses) {
            System.out.println("House Address: "+h.getAddress());
            System.out.println("Owner Name: "+h.getOwnerName());
            System.out.println("Meat Quantity: "+h.getMeat().getT());
            System.out.println("Sacrified : "+(h.isSacrified()?"Yes":"No"));
            System.out.println("------------------------");

        }
    }
}
