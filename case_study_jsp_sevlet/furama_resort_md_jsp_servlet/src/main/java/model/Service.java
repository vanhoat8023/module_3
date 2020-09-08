package model;

public class Service {
    private int id;
    private String name;
    private String area;
    private String cost;
    private String max_people;
    private String standard_room;
    private String description_other_other_convenience;
    private String poll_area;
    private String number_of_floors;

    public Service() {
    }

    public Service(int id, String name, String area, String cost, String max_people, String standard_room, String description_other_other_convenience, String poll_area, String number_of_floors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.standard_room = standard_room;
        this.description_other_other_convenience = description_other_other_convenience;
        this.poll_area = poll_area;
        this.number_of_floors = number_of_floors;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_other_convenience() {
        return description_other_other_convenience;
    }

    public void setDescription_other_other_convenience(String description_other_other_convenience) {
        this.description_other_other_convenience = description_other_other_convenience;
    }

    public String getPoll_area() {
        return poll_area;
    }

    public void setPoll_area(String poll_area) {
        this.poll_area = poll_area;
    }

    public String getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(String number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
