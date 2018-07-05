package pojos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Data {
    private String salaID;
    private List<Item> itemList;
    private Salesman salesman;


    public Sale(String saleID, List<Item> itemList){
        this.salaID = saleID;
        this.itemList = itemList;
    }

}
