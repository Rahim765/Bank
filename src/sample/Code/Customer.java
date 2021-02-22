package sample.Code;

public class Customer {

    public Customer(String name, String number, String cost, String arzCost) {
        this.name = name;
        this.number = number;
        this.cost = cost;
        this.arzCost = arzCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public String getCost() {
        return this.cost;
    }

    public String getArzCost() {
        return arzCost;
    }

    public void setArzCost(String arzCost) {
        this.arzCost = arzCost;
    }

    private String name;
    private String number;
    private String cost;
    private String arzCost;
}
