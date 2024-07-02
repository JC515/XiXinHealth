package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.Doctor;
import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.service.DoctorServiceImpl;
import com.xixinhealthcheckup.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {
    final
    DoctorServiceImpl doctorServiceImpl;

    public DoctorController(DoctorServiceImpl doctorServiceImpl) {
        this.doctorServiceImpl = doctorServiceImpl;
    }

    /**
     * 登录接口
     * @param code 登录账号
     * @param password 密码
     * @return 成功返回token，失败返回错误信息
     */
    @GetMapping("/login")
    public Result login(String code, String password) {
        Doctor doctor = doctorServiceImpl.findDoctorByCodeAndPassword(code, password);
        if (doctor == null) {
            return Result.error("用户名或密码错误");
        } else {
            return Result.success(JwtUtil.generateToken(doctor.getDocCode()));
        }
    }

    /**
     * 注册
     * @param doctor 医生信息
     * @return 成功返回成功信息，失败返回错误信息
     */
    @PostMapping("/register")
    public Result register(@RequestBody Doctor doctor) {
        //查找是否存在一样的登录账号
        Doctor haveDoctor = doctorServiceImpl.findDoctorByCode(doctor.getDocCode());
        //如果存在
        if (haveDoctor != null) {
            return Result.error("该用户名已存在");
        }
        doctorServiceImpl.saveDoctor(doctor);
        return Result.success();
    }

    /**
     * 获取医生姓名
     * @param docCode 医生账号
     * @return 成功返回医生姓名，失败返回错误信息
     */
    @GetMapping("/getName")
    public Result<String> getDoctorInfo(@RequestParam String docCode) {
        return Result.success(doctorServiceImpl.findDoctorByCode(docCode).getRealName());
    }
}
