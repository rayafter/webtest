package fu.com.mapper;

import fu.com.entity.Publisher;

public interface PublisherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}