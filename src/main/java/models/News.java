package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class News {
    private String generalContent;
    private String departmentContent;
    private int departmentId;
    private LocalDateTime publishedAt;
//    private static ArrayList<News> instances = new ArrayList<>();

    public News(){
        this.generalContent = generalContent;
        this.departmentContent = departmentContent;
        this.departmentId = departmentId;
        this.publishedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {return publishedAt;}
    public String getGeneralContent(){return generalContent;}
    private String getDepartmentContent(){return departmentContent;}
    private int getDepartment(){return departmentId;}
//    public static ArrayList<News> getAll(){return instances;}


}
