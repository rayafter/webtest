package fu.com.controller;

import fu.com.entity.Users;
import fu.com.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UsersController {
    @Resource(name="usersServiceImpl")  //这里引用了在业务实现类中创建的业务
    private UsersService usersService; //业务接口
//    public UsersService getUsersService() {
//        return usersService;
//    }
//    public void setUsersService(UsersService usersService) {
//        this.usersService = usersService;
//    }
    @RequestMapping("suser")
    @ResponseBody
    public void suser(HttpServletResponse response) throws IOException {
        Users users=usersService.selectByPrimaryKey(1);
        response.getWriter().println(users.getName());
    }
}
