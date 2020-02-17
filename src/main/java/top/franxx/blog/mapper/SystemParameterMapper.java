package top.franxx.blog.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.franxx.blog.pojo.SystemParameter;
import top.franxx.blog.pojo.SystemParameterExample;

public interface SystemParameterMapper {
    int countByExample(SystemParameterExample example);

    int deleteByExample(SystemParameterExample example);

    int insert(SystemParameter record);

    int insertSelective(SystemParameter record);

    List<SystemParameter> selectByExample(SystemParameterExample example);

    int updateByExampleSelective(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByExample(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);
}