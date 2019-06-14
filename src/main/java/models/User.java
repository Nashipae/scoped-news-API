package models;


import java.util.Objects;

public class User {
    private int id;
    private String staffName;
    private String staffPosition;
    private String staffRole;
    private int departmentId;

    public User(){}

    public User(String staffName) {
        this.staffName = staffName;
    }

    public User(String staffName, String staffPosition, String staffRole, int departmentId ) {
        this.staffName = staffName;
        this.staffPosition= staffPosition;
        this.staffRole = staffRole;


    }

    public void setId (int id) {this.id = id;}
    public int getId() {return id;}

    public void setStaffName(){this.staffName = staffName;}
    public String getStaffName(){return staffName;}

    public void setDepartment(int departmentId){this.departmentId = this.departmentId;}
    public int getDepartment(){return departmentId;}

    public void setStaffPosition(){this.staffPosition = staffPosition;}
    public String getStaffPosition(){return staffPosition;}

    public void setStaffRole(){this.staffRole = staffRole;}
    public String getStaffRole(){return staffRole;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                departmentId == user.departmentId &&
                Objects.equals(getStaffName(), user.getStaffName()) &&
                Objects.equals(getStaffPosition(), user.getStaffPosition()) &&
                Objects.equals(getStaffRole(), user.getStaffRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStaffName(), getStaffPosition(), getStaffRole(), departmentId);
    }
}


