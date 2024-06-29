package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.pojo.Doctor;

public interface DoctorService {
    Doctor findDoctorByCodeAndPassword(String code, String password);

    void saveDoctor(Doctor doctor);

    Doctor findDoctorByCode(String docCode);
}
