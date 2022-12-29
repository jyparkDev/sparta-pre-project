package sparta.prestudy.fans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class FansServiceTest {

    @Autowired FansService fansService;

    @BeforeEach
    void beforeEach(){
        fansService.removeAll();
    }

    @Test
    void createFan() {
        Fan fan = new Fan(0L,"jypark","응원합니다");
        Long findId = fansService.createFan(fan);

        assertThat(findId).isEqualTo(1L);
    }

    @Test
    void findFans() {
        Fan fan = new Fan(0L,"jypark","응원합니다");
        Fan fan2 = new Fan(0L,"jypark","응원합니다");
        Long findId = fansService.createFan(fan);
        Long findId2 = fansService.createFan(fan2);

        List<Fan> all_fans = fansService.findFans();

        assertThat(all_fans.size()).isEqualTo(2);
        assertThat(findId).isEqualTo(1);
        assertThat(findId2).isEqualTo(2);
    }
}