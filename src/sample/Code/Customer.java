package sample.Code;

public class Customer {

    public Customer(String name, String number, String cost) {
        this.name = name;
        this.number = number;
        this.cost = cost;
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


    private String name;
    private String number;
    private String cost;
}
