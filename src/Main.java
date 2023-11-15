

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        House<Mutton> house1=new House<>("house 1","abdul basheer",new Mutton(78.0),true);
        House<Beef> house2=new House<Beef>("house 2","abdul sattar",new Beef(0.0),false);
        House<Mutton> house3=new House<Mutton>("house 3","abdul majeed",new Mutton(0.0),false);
        House<Beef> house4=new House<Beef>("house 4","abdul taha",new Beef(34.0),true);
        House<Beef> house5=new House<Beef>("house 5","abdul javad",new Beef(65.0),true);
        ArrayList <House<? extends Meat<? extends Number>>> houses=new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);
        MeatDistributionSystem<? extends Meat< ? extends Number>> s1=new MeatDistributionSystem<>(houses);
        s1.distributeMeat();
        s1.printHouses();



    }}
