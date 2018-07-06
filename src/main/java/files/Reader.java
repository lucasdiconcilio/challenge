package files;

import pojos.*;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;

public class Reader{

    private static final String SALESMAN = "001";
    private static final String CUSTOMER = "002";
    private static final String SALE = "003";
    private static final char INFORMATIONSPLITTER = 'ç';
    private static File file;
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Salesman> salesmanList = new ArrayList<>();

    public Reader(File file){
        this.file = file;
    }


    public void analyser() throws IOException {

        FileInputStream inputStream = null;
        Scanner scanner = null;
        try {
            inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("(?= 0)");
                for (int i = 0; i < data.length; i++) {
                    createObject(data[i].trim());
                }
            }
            if (scanner.ioException() != null) {
                throw scanner.ioException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }


    public void createObject(String data) {
        String[] dataSplit = data.split(String.valueOf(INFORMATIONSPLITTER));
        switch (dataSplit[0]) {

            case SALESMAN:
                salesmanList.add(new Salesman(dataSplit[1], dataSplit[2], Double.parseDouble(dataSplit[3])));
                break;

            case CUSTOMER:
                customerList.add(new Customer(dataSplit[1], dataSplit[2], dataSplit[3]));
                break;

            case SALE:
                searchSalesman(dataSplit[3]).addSale(new Sale(dataSplit[1], createItemList(dataSplit[2])));
                break;

        }

    }

    public Item createItem(String item) {
        String[] itemSplit = item.split("-");
        return new Item(Integer.parseInt(itemSplit[0]), Integer.parseInt(itemSplit[1]), Double.parseDouble(itemSplit[2]));
    }

    public List<Item> createItemList(String itensString) {
        List<Item> itemList = new ArrayList<>();
        itensString = (itensString.substring(1, itensString.length() - 1));
        String[] itemSplit = itensString.split(",");
        for (int i = 0; i < itemSplit.length; i++) {
            itemList.add(createItem(itemSplit[i]));
        }
        return itemList;
    }

    public Salesman searchSalesman(String name) {
        for (Salesman salesman : salesmanList) {
            if (salesman.getName().contains(name))
                return salesman;
        }
        return null;
    }

    public static int getNumberOfSalesMan(){
        return salesmanList.size();
    }

    public static int getNumberOfClients(){
        return customerList.size();
    }




}


