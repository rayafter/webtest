package fu.com.service;

import fu.com.entity.Admin;
import fu.com.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(Integer id);

    int deleteAll(List list);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll(); //查询所有管理员的信息

    int checkCategory(@Param("name") String name); //名称进行查询

    int checkPass(@Param("pass") String pass);

    boolean checkNameAndPass(String name,String pass);//用户和密码进行查询

}