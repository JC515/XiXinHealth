package com.xixinhealthcheckup.mapper;

import com.xixinhealthcheckup.pojo.Doctor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DoctorMapper {
    @Select("select * from doctor where doc_code=#{code} and password=#{password}")
    Doctor selectDoctorByCodeByPass(String code, String password);

    @Insert("insert into doctor(doc_code, real_name, password, sex, dept_no) values (#{docCode}, #{realName}, #{password}, #{sex}, #{deptNo})")
    void insertDoctor(Doctor doctor);

    @Select("select * from doctor where doc_code=#{code}")
    Doctor selectDoctorByCode(String code);
}
