package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class News {
    private String generalContent;
//    private String departmentContent;
    private String department;
    private LocalDateTime publishedAt;
//    private static ArrayList<News> instances = new ArrayList<>();

    public News(){
        this.generalContent = generalContent;
//        this.departmentContent = departmentContent;
        this.department = department;
        this.publishedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {return publishedAt;}
    public String getGeneralContent(){return generalContent;}
//    private String getDepartmentContent(){return departmentContent;}
    private String getDepartment(){return department;}
//    public static ArrayList<News> getAll(){return instances;}


}
