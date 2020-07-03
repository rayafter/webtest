package fu.com.service.impl;

import fu.com.entity.Admin;
import fu.com.entity.Category;
import fu.com.mapper.CategoryMapper;
import fu.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteAll(List list) {
        return categoryMapper.deleteAll(list);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return  categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int checkCategory(String name) {
        return categoryMapper.checkCategory(name);
    }
    @Override
    public int checkPass(String pass) {
        return categoryMapper.checkPass(pass);
    }

    @Override
    public boolean checkNameAndPass(String name, String pass) {
        if((checkCategory(name)>0) && (checkPass(pass)>0)){
            return true;
        }else{
            return false;
        }
    }
}
