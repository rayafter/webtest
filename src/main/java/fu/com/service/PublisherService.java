package fu.com.service;

import fu.com.entity.Publisher;

public interface PublisherService {
    int deleteByPrimaryKey(Integer id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}