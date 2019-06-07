package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private LocalDateTime createdAt;
    private int id;
//    private static ArrayList<Department> instances = new ArrayList<>();


    public Department(String name) {
        this.name = name;
//        instances.add(this);
//        this.id = instances.size();
        this.createdAt = LocalDateTime.now();
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public LocalDateTime getCreatedAt() {return createdAt;}


//    public static ArrayList<Department> getAll(){return instances;}
//    public static Department findById(int id){return instances.get(id-1);}
////    public void update(String content) {this.name = content;}
//    public void deleteDepartment(){instances.remove(id-1);}
//    public static void clearAllDeparments(){instances.clear();}

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

}



