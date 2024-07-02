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

    /**
     * 获取全部结果列表
     * @param orderId 订单id
     * @return 全部结果列表
     */
    @GetMapping("/getOverAllResultList")
    public Result<List<OverAllResult>> getOverAllResultList(@RequestParam String orderId) {
        List<OverAllResult> overAllResultList = overAllResultImpl.getOverAllResultList(orderId);
        return Result.success(overAllResultList);
    }

    /**
     * 添加总验报告
     * @param overAllResult 总验报告
     * @return 成功或失败
     */
    @PostMapping("/addOverAllResult")
    public Result addOverAllResult(@RequestBody OverAllResult overAllResult) {
        overAllResultImpl.addOverAllResult(overAllResult);
        return Result.success();
    }

    /**
     * 更新总验报告
     * @param overAllResult 总验报告
     * @return 成功或失败
     */
    @PostMapping("/updateOverAllResultByorId")
    public Result updateOverAllResultByorId(@RequestBody OverAllResult overAllResult) {
        log.info(overAllResult.toString());
        overAllResultImpl.updateOverAllResultByorId(overAllResult);
        return Result.success();
    }

    /**
     * 删除总验报告
     * @param orId 总验报告id
     * @return 成功或失败
     */
    @DeleteMapping("/deleteOverAllResultByorId")
    public Result deleteOverAllResultByorId(@RequestParam String orId) {
        overAllResultImpl.deleteOverAllResultByorId(orId);
        return Result.success();
    }

    /**
     * 获取血常规总结
     * @param orderId 订单id
     * @return 血常规总结
     */
    @GetMapping("/getXue")
    public Result<Xue> getXue(@RequestParam String orderId) {
        Xue xue = overAllResultImpl.getXue(orderId);
        return Result.success(xue);
    }

    /**
     * 更新血常规总结
     * @param xue 血常规总结
     * @return 成功或失败
     */
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

    /**
     * 获取肾功能总结
     * @param orderId 订单id
     * @return 肾功能总结
     */
    @GetMapping("/getSheng")
    public Result<Sheng> getSheng(@RequestParam String orderId) {
        Sheng sheng = overAllResultImpl.getSheng(orderId);
        return Result.success(sheng);
    }

    /**
     * 更新肾功能总结
     * @param sheng 肾功能总结
     * @return 成功或失败
     */
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
