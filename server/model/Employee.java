package ua.tntu.server.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "employeeEntity")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;
    @Column(name = "employeeName")
    private String employeeName;
    @Column(name = "employeePosition")
    private String employeePosition;
    @Column(name = "employeeStatus")
    private String employeeStatus;
    @Column(name = "startTime")
    private LocalTime startTime;
    @Column(name = "endTime")
    private LocalTime endTime;
    @Column(name = "cardCode")
    private String cardCode;

    @OneToOne(mappedBy = "employee")
    private User user;
    @OneToMany(mappedBy = "employee")
    private List<Entry> entryList;
    @OneToMany(mappedBy = "employee")
    private List<WorkDay> dayList;

    public Employee() {}

    public Employee(String employeeName, String employeePosition, String employeeStatus,
                    LocalTime startTime, LocalTime endTime, String cardCode) {
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeStatus = employeeStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cardCode = cardCode;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
