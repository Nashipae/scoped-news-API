package models;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                staffName.equals(users.staffName) &&
                Objects.equals(staffPosition, users.staffPosition) &&
                Objects.equals(staffRole, users.staffRole) &&
                department.equals(users.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staffName, staffPosition, staffRole, department);
    }
}


