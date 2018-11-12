import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminTest extends BasicTest {
    @Resource
    /*private AdminDAO adminDAO;*/
    private AdminService adminService;
    //登陆
    /*@Test
    public void Adminlogin(){
        Admin adm=new Admin();
        adm.setName("123");
        adm.setPassword("ffff");
        Admin ad=adminDAO.queryLogin(adm);
        System.out.println(ad);
    }*/
    //修改密码
    @Test
    public void updateAdmin(){
        Admin admin=new Admin();
        admin.setName("222");
        admin.setPassword("333");
        admin.setId("1");
       /* adminDAO.update(admin);*/
        adminService.motify(admin);
    }
    //根据id查询管理员
    @Test
    public void findById(){
        Admin admin=new Admin();
        admin.setName("222");
        admin.setPassword("333");
        admin.setId("1");
       Admin admins=adminService.findById("1");
       // Admin admins = adminDAO.queryLogin(admin);
        System.out.println(admins);
    }
}
