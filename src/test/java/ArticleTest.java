import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.util.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ArticleTest extends BasicTest {
    @Resource
    private ArticleDAO articleDAO;
    @Test
    public void articleFindALL(){
      List<Article> Articles= articleDAO.queryAllPageArticle(0,1,"s");
        for(Article as:Articles){
            System.out.println(as);
        }
    }
}
