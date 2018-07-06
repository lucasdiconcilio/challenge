package pojos;

public class Customer {
    private String cnpj;
    private String name;
    private String BusinessArea;


    public Customer(String cnpj, String name, String businessArea){
        this.cnpj = cnpj;
        this.name = name;
        this.BusinessArea = businessArea;
    }
}
