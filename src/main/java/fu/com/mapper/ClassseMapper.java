package fu.com.mapper;

import fu.com.entity.Classse;

public interface ClassseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classse record);

    int insertSelective(Classse record);

    Classse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classse record);

    int updateByPrimaryKey(Classse record);
}