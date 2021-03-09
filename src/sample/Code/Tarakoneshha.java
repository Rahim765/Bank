package sample.Code;

public class Tarakoneshha {

    public Tarakoneshha(String name, String number, String cost, String arzCost,String date , String tarakonesh){
        this.name = name;
        this.number = number;
        this.cost = cost;
        this.arzCost = arzCost;
        this.date = date;
        this.tarakonesh  = tarakonesh;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTarakonesh() {
        return tarakonesh;
    }

    public void setTarakonesh(String tarakonesh) {
        this.tarakonesh = tarakonesh;
    }

    private String date;
    private String tarakonesh;
    private String name;
    private String number;
    private String cost;
    private String arzCost;
}
