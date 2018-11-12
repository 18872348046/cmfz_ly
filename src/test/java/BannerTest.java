import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.util.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BannerTest extends BasicTest {
    @Resource
    private BannerService bannerService;
    @Test
    public void findAllBanner(){
      List<Banner> banners=bannerService.findAllPage(1,2);
        System.out.println(banners);

    }
}
