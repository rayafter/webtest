package fu.com.service.impl;

import fu.com.entity.Major;
import fu.com.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("majorServiceImpl")
public class MajorServiceImpl implements MajorMapper {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return majorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    @Override
    public int insertSelective(Major record) {
        return majorMapper.insertSelective(record);
    }

    @Override
    public Major selectByPrimaryKey(Integer id) {
        return majorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return majorMapper.updateByPrimaryKey(record);
    }
}
