package product_management.model;

public class Element {
    private int id;
    private String name;
    private String price;
    private String desc;
    private String producer;

    public Element() {
    }

    public Element(int id, String name, String price, String desc, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}