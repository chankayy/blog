package top.franxx.blog.mapper;

import org.apache.ibatis.annotations.Param;
import top.franxx.blog.pojo.Share;
import top.franxx.blog.pojo.ShareExample;

import java.util.List;

public interface ShareMapper {
    int countByExample(ShareExample example);

    int deleteByExample(ShareExample example);

    int deleteByPrimaryKey(Long shareId);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(Long shareId);

    int updateByExampleSelective(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExample(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}