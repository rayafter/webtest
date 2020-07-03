package fu.com.service;

import fu.com.entity.Jc;
import fu.com.entity.JcWithBLOBs;

public interface JcService {
    int deleteByPrimaryKey(Integer id);

    int insert(JcWithBLOBs record);

    int insertSelective(JcWithBLOBs record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JcWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record);

    int updateByPrimaryKey(Jc record);
}