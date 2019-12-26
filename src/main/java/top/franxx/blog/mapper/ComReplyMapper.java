package top.franxx.blog.mapper;

import org.apache.ibatis.annotations.Param;
import top.franxx.blog.pojo.ComReply;
import top.franxx.blog.pojo.ComReplyExample;

import java.util.List;

public interface ComReplyMapper {
    int countByExample(ComReplyExample example);

    int deleteByExample(ComReplyExample example);

    int deleteByPrimaryKey(Long replyId);

    int insert(ComReply record);

    int insertSelective(ComReply record);

    List<ComReply> selectByExampleWithBLOBs(ComReplyExample example);

    List<ComReply> selectByExample(ComReplyExample example);

    ComReply selectByPrimaryKey(Long replyId);

    int updateByExampleSelective(@Param("record") ComReply record, @Param("example") ComReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") ComReply record, @Param("example") ComReplyExample example);

    int updateByExample(@Param("record") ComReply record, @Param("example") ComReplyExample example);

    int updateByPrimaryKeySelective(ComReply record);

    int updateByPrimaryKeyWithBLOBs(ComReply record);

    int updateByPrimaryKey(ComReply record);
}