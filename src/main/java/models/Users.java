package models;

public class Users {
    private int id;
    private String staffName;
    private String staffPosition;
    private String staffRole;
    private String department;

    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public void setStaffName(){this.staffName = staffName;}
    public String getStaffName(){return staffName;}

    public void setDepartment(){this.department = department;}
    public String getDepartment(){return department;}

    public void setStaffPosition(){this.staffPosition = staffPosition;}
    public String getStaffPosition(){return staffPosition;}

    public void setStaffRole(){this.staffRole = staffRole;}
    public String getStaffRole(){return staffRole;}


}


