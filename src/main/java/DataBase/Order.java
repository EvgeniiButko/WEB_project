package DataBase;

public class Order {
    private int id;
    private String city;
    private String name;
    private String sername;
    private String number;
    private String mail;
    private String inf;

    public Order(int id,String city,String name, String sername, String number, String mail,String inf){
        this.id = id;
        this.city = city;
        this.mail = mail;
        this.name = name;
        this.number = number;
        this.sername = sername;
        this.inf = inf;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public String getSername() {
        return sername;
    }

    public int getId() {
        return id;
    }
}
