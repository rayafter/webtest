package fu.com.service.impl;

import fu.com.entity.Publisher;
import fu.com.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("publisherServiceImpl")
public class PublisherServiceImpl implements PublisherMapper {
    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return publisherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Publisher record) {
        return publisherMapper.insert(record);
    }

    @Override
    public int insertSelective(Publisher record) {
        return publisherMapper.insertSelective(record);
    }

    @Override
    public Publisher selectByPrimaryKey(Integer id) {
        return publisherMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Publisher record) {
        return publisherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Publisher record) {
        return publisherMapper.updateByPrimaryKey(record);
    }
}
