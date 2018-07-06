package pojos;

import java.util.ArrayList;
import java.util.List;

public class Salesman {

    private String cpf;
    private String name;
    private double salary;
    private List<Sale> saleList = new ArrayList<>();

    public Salesman(String cpf, String name, double salary){
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        double amountSold = getAmountSold();
    }

    public void addSale(Sale sale){
        saleList.add(sale);
    }

    public String getName(){
        return name;
    }

    public double getAmountSold(){
        double calculateAmount= 0;
        for (Sale sale:saleList
             ) { calculateAmount = calculateAmount + sale.getSalePrice();
        }
        return calculateAmount;
    }


}
