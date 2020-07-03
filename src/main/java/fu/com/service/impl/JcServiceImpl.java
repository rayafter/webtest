package fu.com.service.impl;

import fu.com.entity.Jc;
import fu.com.entity.JcWithBLOBs;
import fu.com.mapper.JcMapper;
import org.springframework.stereotype.Service;

@Service("jcServiceImpl")
public class JcServiceImpl implements JcMapper {
    private JcMapper jcMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return jcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JcWithBLOBs record) {
        return jcMapper.insert(record);
    }

    @Override
    public int insertSelective(JcWithBLOBs record) {
        return jcMapper.insertSelective(record);
    }

    @Override
    public JcWithBLOBs selectByPrimaryKey(Integer id) {
        return jcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JcWithBLOBs record) {
        return jcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record) {
        return jcMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Jc record) {
        return jcMapper.updateByPrimaryKey(record);
    }
}
