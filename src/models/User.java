package models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import services.IModel;
import services.Security;

import java.util.Date;
import java.text.SimpleDateFormat;

@DatabaseTable(tableName = "user")
public class User implements IModel {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(width = 30)
    private String firstName;
    @DatabaseField(width = 30)
    private String middleName;
    @DatabaseField(width = 30)
    private String lastName;
    @DatabaseField(width = 30)
    private String username;
    @DatabaseField(width = 30)
    private String normalizedUsername;
    @DatabaseField(width = 256)
    private String password;
    @DatabaseField(width = 30)
    private String phone;
    @DatabaseField(width = 30)
    private String role;
    @DatabaseField(dataType = DataType.DATE)
    private Date dateOfBirth;
    @DatabaseField(width = 7)
    private String gender;

    public User(){ }

    public User(String firstName, String middleName, String lastName,
                String username, String password, String phone,
                Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.normalizedUsername = username.toUpperCase();
        this.password = Security.hash(password);
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.normalizedUsername = username.toUpperCase();
    }

    public String getNormalizedUsername() {
        return normalizedUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Security.hash(password);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateOfBirth() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
