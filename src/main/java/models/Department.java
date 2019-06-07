package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Department {
    private String name;
    private LocalDateTime createdAt;
    private int id;
//    private static ArrayList<Department> instances = new ArrayList<>();


    public Department() {
        this.name = name;
//        instances.add(this);
//        this.id = instances.size();
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {return id;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public String getName(){return name;}
//    public static ArrayList<Department> getAll(){return instances;}
//    public static Department findById(int id){return instances.get(id-1);}
////    public void update(String content) {this.name = content;}
//    public void deleteDepartment(){instances.remove(id-1);}
//    public static void clearAllDeparments(){instances.clear();}


    }



