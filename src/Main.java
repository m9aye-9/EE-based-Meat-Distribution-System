import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        House house1=new House("house 1","abdul basheer",new Meat(98.0,MeatType.BEEF),true);
        House house2=new House("house 2","abdul sattar",new Meat(0.0,MeatType.BEEF),false);
        House house3=new House("house 3","abdul majeed",new Meat(0.0,MeatType.BEEF),false);
        House house4=new House("house 4","abdul taha",new Meat(67.3,MeatType.CAMELMEAT),true);
        House house5=new House("house 5","abdul javad",new Meat(78.9,MeatType.MUTTON),true);
        ArrayList <House> houses=new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);
        FileUtils.writeToFile(houses,"MeatDataInfo.txt");
        MeatDistributionSystem s1=new MeatDistributionSystem(houses);
        s1.distributeMeat();
        s1.printHouses();
        FileUtils.readFromFile("MeatDataInfo.txt");



    }}