package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class News {
    private int id;
    private String generalContent;
    private String departmentContent;
    private int departmentId;
    private LocalDateTime publishedAt;
//    private static ArrayList<News> instances = new ArrayList<>();

    public News(){
        this.id = id;
        this.generalContent = generalContent;
        this.departmentContent = departmentContent;
        this.departmentId = departmentId;
        this.publishedAt = LocalDateTime.now();
    }

//    public LocalDateTime getCreatedAt() {return publishedAt;}
//    public String getGeneralContent(){return generalContent;}
//    private String getDepartmentContent(){return departmentContent;}
//    private int getDepartment(){return departmentId;}
//    private int getId(){return id;}
//    public static ArrayList<News> getAll(){return instances;}


    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public String getDepartmentContent() {
        return departmentContent;
    }

    public void setDepartmentContent(String departmentContent) {
        this.departmentContent = departmentContent;
    }

    public String getGeneralContent() {
        return generalContent;
    }

    public void setGeneralContent(String generalContent) {
        this.generalContent = generalContent;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }
}
