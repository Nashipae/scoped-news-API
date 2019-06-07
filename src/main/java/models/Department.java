package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int employeeCount;
    private LocalDateTime createdAt;
    private int id;
//    private static ArrayList<Department> instances = new ArrayList<>();

    public Department(){}


    public Department(String name) {
        this.name = name;
    }

    public Department(String name, String description) {
        this.name = name;
        this.description= description;
        this.createdAt = LocalDateTime.now();
    }


    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    //    public static ArrayList<Department> getAll(){return instances;}
//    public static Department findById(int id){return instances.get(id-1);}
////    public void update(String content) {this.name = content;}
//    public void deleteDepartment(){instances.remove(id-1);}
//    public static void clearAllDeparments(){instances.clear();}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return employeeCount == that.employeeCount &&
                id == that.id &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, employeeCount, createdAt, id);
    }
}



