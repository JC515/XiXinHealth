package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.mapper.OverAllResultMapper;
import com.xixinhealthcheckup.pojo.OverAllResult;
import com.xixinhealthcheckup.pojo.Sheng;
import com.xixinhealthcheckup.pojo.Xue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverAllResultImpl {
    final
    OverAllResultMapper overAllResultMapper;

    public OverAllResultImpl(OverAllResultMapper overAllResultMapper) {
        this.overAllResultMapper = overAllResultMapper;
    }

    public List<OverAllResult> getOverAllResultList(String orderId) {
        return overAllResultMapper.getOverAllResultList(orderId);
    }

    public void addOverAllResult(OverAllResult overAllResult) {
        overAllResultMapper.addOverAllResult(overAllResult);
    }

    public void updateOverAllResultByorId(OverAllResult overAllResult) {
        overAllResultMapper.updateOverAllResultByorId(overAllResult);
    }

    public void deleteOverAllResultByorId(String orId) {
        overAllResultMapper.deleteOverAllResultByorId(orId);
    }

    public Xue getXue(String orderId) {
        return overAllResultMapper.getXue(orderId);
    }

    public void updateXue(Xue xue) {
        overAllResultMapper.updateXue(xue);
    }

    public Sheng getSheng(String orderId) {
        return overAllResultMapper.getSheng(orderId);
    }

    public void updateSheng(Sheng sheng) {
        overAllResultMapper.updateSheng(sheng);
    }

    public void addXue(Xue xue) {
        overAllResultMapper.addXue(xue);
    }

    public void addSheng(Sheng sheng) {
        overAllResultMapper.addSheng(sheng);
    }
}
