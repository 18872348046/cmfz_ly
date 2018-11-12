import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import com.baizhi.util.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class MenuTest extends BasicTest {
    @Resource
    private MenuDAO menuDAO;
    @Test
    public void findAllMenu(){
       List<Menu> menus=menuDAO.queryAllMenu();
        for (Menu me:menus){
            System.out.println(me);
        }
    }
}
