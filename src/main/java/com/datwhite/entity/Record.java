package com.datwhite.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Record")
public class Record {
    @Id
    private String cardNumber;

    private String patient_name;

    private String patient_surname;

    private String patient_patronymic;

    private String record_date;

    private String record_time;

    private String phone_number;

    private int MEDORG_ID;

    private int DOCT_ID;

    private int BRA_ID;

    private int WORK_ID;

    private String patient_age;

    public Record() {
    }

    public Record(String cardNumber,
                  String patient_name,
                  String patient_surname,
                  String patient_patronymic,
                  String record_date,
                  String record_time,
                  String phone_number,
                  String patient_age,
                  int MEDORG_ID,
                  int DOCT_ID,
                  int BRA_ID,
                  int WORK_ID) {
        this.cardNumber = cardNumber;
        this.patient_name = patient_name;
        this.patient_surname = patient_surname;
        this.patient_patronymic = patient_patronymic;
        this.record_date = record_date;
        this.record_time = record_time;
        this.phone_number = phone_number;
        this.patient_age = patient_age;
        this.MEDORG_ID = MEDORG_ID;
        this.DOCT_ID = DOCT_ID;
        this.BRA_ID = BRA_ID;
        this.WORK_ID = WORK_ID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public String getPatient_surname() {
        return patient_surname;
    }

    public void setPatient_surname(String patient_surname) {
        this.patient_surname = patient_surname;
    }

    public String getPatient_patronymic() {
        return patient_patronymic;
    }

    public void setPatient_patronymic(String patient_patronymic) {
        this.patient_patronymic = patient_patronymic;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(String patient_age) {
        this.patient_age = patient_age;
    }

    public int getMEDORG_ID() {
        return MEDORG_ID;
    }

    public void setMEDORG_ID(int MEDORG_ID) {
        this.MEDORG_ID = MEDORG_ID;
    }

    public int getDOCT_ID() {
        return DOCT_ID;
    }

    public void setDOCT_ID(int DOCT_ID) {
        this.DOCT_ID = DOCT_ID;
    }

    public int getBRA_ID() {
        return BRA_ID;
    }

    public void setBRA_ID(int BRA_ID) {
        this.BRA_ID = BRA_ID;
    }

    public int getWORK_ID() {
        return WORK_ID;
    }

    public void setWORK_ID(int WORK_ID) {
        this.WORK_ID = WORK_ID;
    }
}
