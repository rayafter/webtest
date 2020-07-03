package fu.com.controller;

import fu.com.entity.Admin;
import fu.com.entity.AdminId;
import fu.com.mapper.AdminMapper;
import fu.com.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Resource(name="adminServiceImpl")
    @Autowired
    private AdminService adminService;

    @RequestMapping("/deleteAll")
    @ResponseBody
    public ServerResponse deleteAll(@RequestBody AdminId list){
        long id[]=list.getId();
        List ll=new ArrayList();
        for(long i:id){
            ll.add(i);
        }
        if(adminService.deleteAll(ll)>0){
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
        if(adminService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccessMessage("删除数据成功");
        }else{
            return ServerResponse.createByErrorMessage("删除数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Admin admin=adminService.selectByPrimaryKey(id);
        if(admin!=null){
            return ServerResponse.createBySuccess(0,admin);
        }else{
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Admin record){
        if(adminService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }
        else{
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Admin record){
        if(adminService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }
        else{
            return ServerResponse.createByError();
        }
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Admin record){
        System.out.println(record.getId());
        if(adminService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccess("更新管理数据成功",record);
        }else{
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Admin record){
        if(adminService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccess("更新管理数据成功",record);
        }else{
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public ServerResponse selectAll() {
        List<Admin> list=adminService.selectAll();

        for(Admin a:list){
            System.out.println(a.getName());
        }
        if(list.size()>0){
            return ServerResponse.createBySuccess(0,list);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }

    @RequestMapping(value = "/checkAdmin",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse checkAdmin(String name) {
        if(adminService.checkAdmin(name)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }

    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ServerResponse checkEmail(String email) {
        if(adminService.checkAdmin(email)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public ServerResponse checkPhone(String phone) {
        if(adminService.checkAdmin(phone)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/checkPass")
    @ResponseBody
    public ServerResponse checkPass(String pass) {
        if(adminService.checkAdmin(pass)>0){
            return ServerResponse.createBySuccessMessage("用户存在");
        }else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    @RequestMapping("/checkNameAndPass")
    @ResponseBody
    public ServerResponse  checkNameAndPass(@Param("name") String name, @Param("pass") String pass){
        if(adminService.checkAdmin(name)>0 && adminService.checkPass(pass)>0){
            return ServerResponse.createBySuccess(0);
        }else{
            return ServerResponse.createByErrorMessage("输入的管理员和密码错误");
        }
    }

    @RequestMapping("/checkEmailAndPass")
    @ResponseBody
    public ServerResponse  checkEmailAndPass(@Param("email") String email,@Param("pass") String pass){
        if(adminService.checkEmail(email)>0 && adminService.checkPass(pass)>0){
            return ServerResponse.createBySuccess(0);
        }else{
            return ServerResponse.createByErrorMessage("输入的邮箱和密码错误");
        }
    }

    @RequestMapping("/checkPhoneAndPass")
    @ResponseBody
    public ServerResponse  checkPhoneAndPass(@Param("phone") String phone,@Param("pass") String pass){
        if(adminService.checkPhone(phone)>0 && adminService.checkPass(pass)>0){
            return ServerResponse.createBySuccess(0);
        }else{
            return ServerResponse.createByErrorMessage("输入的电话和密码错误");
        }
    }

}
