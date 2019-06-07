package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int employeesTotal;
    private LocalDateTime createdAt;
    private int id;
//    private static ArrayList<Department> instances = new ArrayList<>();


    public Department(String name) {
        this.name = name;
        this.description= description;
        this.employeesTotal = employeesTotal;
//        instances.add(this);
//        this.id = instances.size();
        this.createdAt = LocalDateTime.now();
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public void setEmployeesTotal(){this.employeesTotal = employeesTotal;}
    public int getEmployeesTotal(){return employeesTotal;}

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



