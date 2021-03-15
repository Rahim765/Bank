package sample.Code;

public class Customer {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, String fname, String vallage, String number,
                    String afghani, String toman, String dollar, String kaldar, String uru) {
        this.name = name;
        this.fname = fname;
        this.vallage = vallage;
        this.number = number;
        this.afghani = afghani;
        this.toman = toman;
        this.dollar = dollar;
        this.kaldar = kaldar;
        this.uru = uru;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getVallage() {
        return vallage;
    }

    public void setVallage(String vallage) {
        this.vallage = vallage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAfghani() {
        return afghani;
    }

    public void setAfghani(String afghani) {
        this.afghani = afghani;
    }

    public String getToman() {
        return toman;
    }

    public void setToman(String toman) {
        this.toman = toman;
    }

    public String getDollar() {
        return dollar;
    }

    public void setDollar(String dollar) {
        this.dollar = dollar;
    }

    public String getKaldar() {
        return kaldar;
    }

    public void setKaldar(String kaldar) {
        this.kaldar = kaldar;
    }

    public String getUru() {
        return uru;
    }

    public void setUru(String uru) {
        this.uru = uru;
    }

    private String name;
    private String fname;
    private String vallage;
    private String number;
    private String afghani;
    private String toman;
    private String dollar;
    private  String kaldar;
    private String uru;
}
