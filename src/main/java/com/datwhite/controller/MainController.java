package com.datwhite.controller;

import com.datwhite.api.SiMedService;
import com.datwhite.entity.PatientRecordBody;
import com.datwhite.entity.Record;
import com.datwhite.repository.RecordRepo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    private CompositeDisposable disposable = new CompositeDisposable();
    private SiMedService siMedService = new SiMedService();
    ;
    private int IDR;
    private String KEY;
    private int confirmStatus;

    @Autowired
    RecordRepo recordRepo;

    @GetMapping("/")
    public String startPage() {
        return "Hello";
    }

    @PostMapping(path = "/patient", consumes = "application/json", produces = "application/json")
    public Record getPatient(@RequestBody Map<String, String> cardNumber) {
        return recordRepo.findByCardNumber(cardNumber.get("card_number"));
    }

    @GetMapping("/all-patients")
    public List<Record> getAllPatients() {
        return recordRepo.findAll();
    }

    @PostMapping(path = "/insert", consumes = "application/json", produces = "application/json")
    public int insert(@RequestBody Map<String, String> record) {
        try {
            recordRepo.save(new Record(
                    record.get("card_number"),
                    record.get("patient_name"),
                    record.get("patient_surname"),
                    record.get("patient_patronymic"),
                    record.get("record_date"),
                    record.get("record_time"),
                    record.get("phone_number"),
                    record.get("patient_age"),
                    Integer.parseInt(record.get("MEDORG_ID")),
                    Integer.parseInt(record.get("DOCT_ID")),
                    Integer.parseInt(record.get("BRA_ID")),
                    Integer.parseInt(record.get("WORK_ID"))
            ));
            return 1;
        } catch (Exception e) {
            return 0;
        }


    }

    @PostMapping(path = "/record", consumes = "application/json", produces = "application/json")
    public int record(@RequestBody Map<String, String> recordInfo) {
        PatientRecordBody patientRecordBody = new PatientRecordBody(
                Integer.parseInt(recordInfo.get("MEDORG_ID")),
                Integer.parseInt(recordInfo.get("DOCT_ID")),
                Integer.parseInt(recordInfo.get("BRA_ID")),
                Integer.parseInt(recordInfo.get("WORK_ID")),
                recordInfo.get("Date"),
                recordInfo.get("timeInterval"),
                recordInfo.get("Name"),
                recordInfo.get("Phone")
        );

        siMedService.getApi().recording(patientRecordBody).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                IDR = response.body();
                System.out.println("IDR " + IDR);

                siMedService.getApi().getKey(IDR).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        KEY = response.body();
                        System.out.println("KEY " + KEY);

                        siMedService.getApi().confirmation(IDR, Integer.parseInt(KEY)).enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {
                                confirmStatus = response.body();
                                System.out.println("CONFIRM " + confirmStatus);
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable throwable) {
                                System.out.println("CONFIRM FAIL");
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable throwable) {
                        System.out.println("GET KEY FAIL");
                    }
                });

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable throwable) {
                System.out.println("RECORD FAILl");
            }
        });


        return confirmStatus;
    }
}
