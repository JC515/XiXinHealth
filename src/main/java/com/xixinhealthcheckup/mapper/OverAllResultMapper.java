package com.xixinhealthcheckup.mapper;

import com.xixinhealthcheckup.pojo.OverAllResult;
import com.xixinhealthcheckup.pojo.Sheng;
import com.xixinhealthcheckup.pojo.Xue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OverAllResultMapper {
    @Select("select * from overall_result where order_id = #{orderId}")
    List<OverAllResult> getOverAllResultList(String orderId);

    @Insert("insert into overall_result(title, content, order_id) values(#{title}, #{content}, #{orderId}) ")
    void addOverAllResult(OverAllResult overAllResult);

    @Update("update overall_result set title = #{title}, content = #{content} where or_id = #{orId}")
    void updateOverAllResultByorId(OverAllResult overAllResult);

    @Delete("delete from overall_result where or_id = #{orId}")
    void deleteOverAllResultByorId(String orId);

    @Select("select * from xue_chang_gui where order_id = #{orderId}")
    Xue getXue(String orderId);

    @Update("update xue_chang_gui set arg1 = #{arg1}, arg2=#{arg2} where order_id = #{orderId}")
    void updateXue(Xue xue);

    @Select("select * from sheng_gong_neng where order_id = #{orderId}")
    Sheng getSheng(String orderId);

    @Update("update sheng_gong_neng set arg1 = #{arg1}, arg2=#{arg2} where order_id = #{orderId}")
    void updateSheng(Sheng sheng);

    @Insert("insert into xue_chang_gui(arg1, arg2, order_id) values(#{arg1}, #{arg2}, #{orderId})")
    void addXue(Xue xue);

    @Insert("insert into sheng_gong_neng(arg1, arg2, order_id) values(#{arg1}, #{arg2}, #{orderId})")
    void addSheng(Sheng sheng);
}
