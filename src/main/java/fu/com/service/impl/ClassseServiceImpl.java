package fu.com.service.impl;

import fu.com.entity.Classse;
import fu.com.mapper.ClassseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("classseServiceImpl")
public class ClassseServiceImpl implements ClassseMapper {
    @Autowired
    private ClassseMapper classseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classse record) {
        return classseMapper.insert(record);
    }

    @Override
    public int insertSelective(Classse record) {
        return classseMapper.insertSelective(record);
    }

    @Override
    public Classse selectByPrimaryKey(Integer id) {
        return classseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classse record) {
        return classseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classse record) {
        return classseMapper.updateByPrimaryKey(record);
    }
}
