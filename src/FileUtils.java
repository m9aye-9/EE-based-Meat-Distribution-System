import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static void writeToFile(ArrayList<House<? extends Meat<? extends Number>>> houses,String fileName) {
    try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))) {
        for (House<? extends Meat<? extends Number>> house : houses) {
            writer.write(house.getAddress() + "," + house.getOwnerName() + "," + house.getMeat().getT() + "," + house.isSacrified());
            writer.newLine();
        }
        System.out.println("Data written to" + fileName);
    }
    catch (IOException e){
        e.printStackTrace();
    }
    }
    public static ArrayList<House<? extends Meat<? extends Number>>>readFromFile(String filename){
        ArrayList<House<? extends Meat<? extends Number>>> houses=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                String address=parts[0];
                String ownerName=parts[1];
                double meatQuantity=Double.parseDouble(parts[2]);
                boolean sacrified=Boolean.parseBoolean(parts[3]);
                Meat<? extends Number> meat=new Meat<>(meatQuantity);
                House<? extends Meat<? extends Number>> house=new House<>(address,ownerName,meat,sacrified);
                houses.add(house);
            }
            System.out.println("Data read from "+filename);
        }
        catch (IOException|NumberFormatException e){
            e.printStackTrace();
        }
        return houses;
    }
}
