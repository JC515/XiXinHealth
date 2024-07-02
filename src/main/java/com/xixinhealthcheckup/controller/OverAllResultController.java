package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.OverAllResult;
import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.pojo.Sheng;
import com.xixinhealthcheckup.pojo.Xue;
import com.xixinhealthcheckup.service.OverAllResultImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overAllResult")
@CrossOrigin
@Slf4j
public class OverAllResultController {
    final
    OverAllResultImpl overAllResultImpl;

    public OverAllResultController(OverAllResultImpl overAllResultImpl) {
        this.overAllResultImpl = overAllResultImpl;
    }

    @GetMapping("/getOverAllResultList")
    public Result<List<OverAllResult>> getOverAllResultList(@RequestParam String orderId) {
        List<OverAllResult> overAllResultList = overAllResultImpl.getOverAllResultList(orderId);
        return Result.success(overAllResultList);
    }

    @PostMapping("/addOverAllResult")
    public Result addOverAllResult(@RequestBody OverAllResult overAllResult) {
        overAllResultImpl.addOverAllResult(overAllResult);
        return Result.success();
    }

    @PostMapping("/updateOverAllResultByorId")
    public Result updateOverAllResultByorId(@RequestBody OverAllResult overAllResult) {
        log.info(overAllResult.toString());
        overAllResultImpl.updateOverAllResultByorId(overAllResult);
        return Result.success();
    }

    @DeleteMapping("/deleteOverAllResultByorId")
    public Result deleteOverAllResultByorId(@RequestParam String orId) {
        overAllResultImpl.deleteOverAllResultByorId(orId);
        return Result.success();
    }

    @GetMapping("/getXue")
    public Result<Xue> getXue(@RequestParam String orderId) {
        Xue xue = overAllResultImpl.getXue(orderId);
        return Result.success(xue);
    }

    @PostMapping("/updateXue")
    public Result updateXue(@RequestBody Xue xue) {
        //先查看是否存在记录，不存在记录则先新增记录
        Xue oldXue = overAllResultImpl.getXue(String.valueOf(xue.getOrderId()));
        if (oldXue == null) {
            overAllResultImpl.addXue(xue);
        }
        overAllResultImpl.updateXue(xue);
        return Result.success();
    }

    @GetMapping("/getSheng")
    public Result<Sheng> getSheng(@RequestParam String orderId) {
        Sheng sheng = overAllResultImpl.getSheng(orderId);
        return Result.success(sheng);
    }

    @PostMapping("/updateSheng")
    public Result updateSheng(@RequestBody Sheng sheng) {
        //先查看是否存在记录，不存在记录则先新增记录
        Sheng oldSheng = overAllResultImpl.getSheng(String.valueOf(sheng.getOrderId()));
        if (oldSheng == null) {
            overAllResultImpl.addSheng(sheng);
        }
        overAllResultImpl.updateSheng(sheng);
        return Result.success();
    }
}
