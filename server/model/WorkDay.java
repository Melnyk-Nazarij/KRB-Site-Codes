package ua.tntu.server.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workDayEntity")
public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayId")
    private int dayId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "dayStatus")
    private String dayStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee")
    private Employee employee;

    public WorkDay() {}

    public WorkDay(Employee employee, LocalDate date, String dayStatus) {
        this.employee = employee;
        this.date = date;
        this.dayStatus = dayStatus;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
    }
}
