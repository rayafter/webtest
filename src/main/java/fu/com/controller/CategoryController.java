package fu.com.controller;

import javax.annotation.Resource;
import fu.com.entity.Category;
import fu.com.entity.Category;
import fu.com.entity.CategoryID;
import fu.com.mapper.CategoryMapper;
import fu.com.service.CategoryService;
import fu.com.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import fu.com.common.ServerResponse;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Resource(name="categoryServiceImpl")
    @Autowired
    public CategoryService categoryService;


    @RequestMapping("/deleteAll")
    @ResponseBody
    public ServerResponse deleteAll(@RequestBody CategoryID list){
        long id[]=list.getId();
        List ll=new ArrayList();
        for(long i:id){
            ll.add(i);
        }
        if(categoryService.deleteAll(ll)>0){
            return ServerResponse.createBySuccessMessage("删除数据成功");
        }else{
            return ServerResponse.createByErrorMessage("删除数据失败");
        }
    }


    @RequestMapping("/index")
    public String index(){
        return "admin";
    }

    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id){
        if(categoryService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccessMessage("删除数据成功");
        }else{
            return ServerResponse.createByErrorMessage("删除数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Category Category=categoryService.selectByPrimaryKey(id);
        if(Category!=null){
            return ServerResponse.createBySuccess(0,Category);
        }else{
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Category record){
        if(categoryService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }
        else{
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Category record){

        System.out.println("insert");
        if(categoryService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }
        else{
            return ServerResponse.createByError();
        }
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Category record){
        System.out.println("testgengxin");
        System.out.println(record.getId());
        if(categoryService.updateByPrimaryKey(record)>0){
            System.out.println("更新成功");
            return ServerResponse.createBySuccess("更新管理数据成功",record);
        }else{
            System.out.println("失败");
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Category record){
        if(categoryService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccess("更新管理数据成功",record);
        }else{
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public ServerResponse selectAll() {
        List<Category> list=categoryService.selectAll();
        if(list.size()>0){
            return ServerResponse.createBySuccess(0,list);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }

    @RequestMapping(value = "/checkCategory",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse checkCategory(String name) {
        if(categoryService.checkCategory(name)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/checkPass")
    @ResponseBody
    public ServerResponse checkPass(String pass) {
        if(categoryService.checkCategory(pass)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }
    @RequestMapping("/checkNameAndPass")
    @ResponseBody
    public ServerResponse  checkNameAndPass(@Param("name") String name, @Param("pass") String pass){
        if(categoryService.checkCategory(name)>0 && categoryService.checkPass(pass)>0){
            return ServerResponse.createBySuccess(0);
        }else{
            return ServerResponse.createByErrorMessage("输入的管理员和密码错误");
        }
    }
}
