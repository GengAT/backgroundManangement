package cn.yaspped.ssm.dao;

import cn.yasspeed.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {



    @Select("SELECT * FROM `member` where id =#{memberID}")
    public Member findById(String memberID);
}
