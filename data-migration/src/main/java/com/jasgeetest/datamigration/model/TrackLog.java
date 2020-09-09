package com.jasgeetest.datamigration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TrackLog {

    @Id
    private Integer id;
    private Integer orderReferenceNumber;
    private String employeeCode;
    private String employeeName;
    private Date time;

    public TrackLog(Integer id, Integer orderReferenceNumber, String employeeCode, String employeeName, Date time) {
        this.id = id;
        this.orderReferenceNumber = orderReferenceNumber;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderReferenceNumber() {
        return orderReferenceNumber;
    }

    public void setOrderReferenceNumber(Integer orderReferenceNumber) {
        this.orderReferenceNumber = orderReferenceNumber;
    }

    public TrackLog() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TrackLog{" +
                "id=" + id +
                ", orderReferenceNumber=" + orderReferenceNumber +
                ", employeeCode=" + employeeCode +
                ", employeeName='" + employeeName + '\'' +
                ", time=" + time +
                '}';
    }
}
