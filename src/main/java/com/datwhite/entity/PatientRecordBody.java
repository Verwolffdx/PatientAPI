package com.datwhite.entity;

public class PatientRecordBody {
    private int MEDORG_ID;
    private int DOCT_ID;
    private int BRA_ID;
    private int WORK_ID;
    private String Date;
    private String timeInterval;
    private String Name;
    private String Phone;

    public PatientRecordBody() {
    }

    public PatientRecordBody(int MEDORG_ID,
                             int DOCT_ID,
                             int BRA_ID,
                             int WORK_ID,
                             String date,
                             String timeInterval,
                             String name,
                             String phone) {
        this.MEDORG_ID = MEDORG_ID;
        this.DOCT_ID = DOCT_ID;
        this.BRA_ID = BRA_ID;
        this.WORK_ID = WORK_ID;
        Date = date;
        this.timeInterval = timeInterval;
        Name = name;
        Phone = phone;
    }
}
