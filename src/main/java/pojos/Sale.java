package pojos;

import java.util.List;

public class Sale {
    private String salaID;
    private List<Item> itemList;
    private Salesman salesman;


    public Sale(String saleID, List<Item> itemList){
        this.salaID = saleID;
        this.itemList = itemList;
        double salePrice = getSalePrice();
    }

    public double getSalePrice(){
        double salePrice=0;
        for (Item item: itemList
             ) {salePrice = salePrice + item.price;
        }
        return salePrice;
    }

}
