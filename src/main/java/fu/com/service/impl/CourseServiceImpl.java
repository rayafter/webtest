package fu.com.service.impl;

import fu.com.entity.Course;
import fu.com.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseMapper {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }
}
