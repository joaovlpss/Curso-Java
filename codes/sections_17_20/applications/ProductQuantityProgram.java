package sections_17_20.applications;

import java.util.List;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import sections_8_16.entities.Product;

public class ProductQuantityProgram{

    public static void main(String[] args){
        List<Product> lsProducts = new ArrayList<Product>();
        List<String> lsLines = new ArrayList<String>();

        // Getting the data file's path from this file's path.
        File thisFile = new File(System.getProperty("user.dir"));
        File parentFolder = new File(thisFile.getParent());
        File inputFile = new File(parentFolder.getPath() + "/codes/data/ProductEntries.csv");

        // Reading the data file.
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String line = br.readLine();
            while(line != null){
                lsLines.add(line);
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        // Creating a list of products from the data file.
        for (String line : lsLines){
            String[] fields = line.split(",");
            String name = fields[0];
            double price = Double.parseDouble(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            lsProducts.add(new Product(name, price, quantity));
        }

        // Making a new file with the output. The output should be the product's name and the price of the total quantity.
        File outputFile = new File(parentFolder.getPath() + "/codes/data/ProductEntriesOutput.csv");
        List<String> outputLines = new ArrayList<String>();

        for (Product product : lsProducts){
            String name = product.getName();
            double totalPrice = product.getPrice() * product.getQuantity();
            outputLines.add(name + "," + String.format(Locale.ENGLISH, "%.2f", totalPrice)); // We have to use Locale.ENGLISH because the decimal separator is a dot.
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))){
            for (String line : outputLines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
