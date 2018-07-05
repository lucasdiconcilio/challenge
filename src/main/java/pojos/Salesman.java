package pojos;

import java.util.ArrayList;
import java.util.List;

public class Salesman implements Data{

    private String cpf;
    private String name;
    private double salary;
    private List<Sale> saleList = new ArrayList<>();

    public Salesman(String cpf, String name, double salary){
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public void addSale(Sale sale){
        saleList.add(sale);
    }

    public String getName(){
        return name;
    }


}
