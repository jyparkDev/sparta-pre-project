package sparta.prestudy.fans;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FansRepositoryTest {


    @Autowired FansRepository fansRepository;

    @BeforeEach
    public void beforeEach(){
        fansRepository.clearAll();
    }
    @Test
    void 등록(){
        Fan fan = new Fan(1L,"jypark","응원합니다");

        Long findFan = fansRepository.save(fan);
        List<Fan> allFan = fansRepository.findAll();
        assertThat(allFan.size()).isEqualTo(1);
        assertThat(allFan.get(0).getId()).isEqualTo(findFan);
    }

    @Test
    void 모두_조회하기(){
        Fan fan = new Fan(1L,"jypark","응원합니다");
        Fan fan2 = new Fan(2L,"jypark","응원합니다");

        Long findFan = fansRepository.save(fan);
        Long findFan2 = fansRepository.save(fan2);

        List<Fan> allFan = fansRepository.findAll();
        assertThat(allFan.size()).isEqualTo(2);

    }
}