package top.franxx.blog.mapper;

import org.apache.ibatis.annotations.Param;
import top.franxx.blog.pojo.Reply;
import top.franxx.blog.pojo.ReplyExample;

import java.util.List;

public interface ReplyMapper {
    int countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Long replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExampleWithBLOBs(ReplyExample example);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Long replyId);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}