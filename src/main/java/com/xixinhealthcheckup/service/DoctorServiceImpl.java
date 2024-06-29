package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.mapper.DoctorMapper;
import com.xixinhealthcheckup.pojo.Doctor;
import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.util.MD5Util;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    final
    DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    @Override
    public Doctor findDoctorByCodeAndPassword(String code, String password) {
        password = MD5Util.getMD5(password, 20);
        return doctorMapper.selectDoctorByCodeByPass(code, password);
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctor.setPassword(MD5Util.getMD5(doctor.getPassword(), 20));
        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public Doctor findDoctorByCode(String docCode) {
        return doctorMapper.selectDoctorByCode(docCode);
    }


}
