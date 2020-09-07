package main.java.model;

public class Employee {
    private int id;
    private String name;
    private String birthday;
    private double salary;
    private double phone;
    private String email;
    private String address;
    private String id_card;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, double salary, double phone, String email, String address, String id_card) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.id_card = id_card;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }
}
