

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a House;
        Meat m1=new Meat(4.7);
        Meat m2=new Meat(5.8);
        House house1=new House("house 1","abdul basheer",m1,true);
        House house2=new House("house 2","abdul sattar",m2,true);
        House house3=new House("house 3","abdul majeed",new Meat(0),false);
        House house4=new House("house 4","abdul taha",new Meat(0),false);
        House house5=new House("house 5","abdul javad",new Meat(8.2),true);




        ArrayList <House> houses=new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);
        MeatDistributionSystem s1=new MeatDistributionSystem(houses);
        s1.distributeMeat();
        s1.printHouses();



    }}
