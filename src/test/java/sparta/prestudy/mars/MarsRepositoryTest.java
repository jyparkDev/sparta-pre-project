package sparta.prestudy.mars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MarsRepositoryTest {

    @Autowired MarsRepository marsRepository;


    @BeforeEach
    void clearAllRecord(){
        marsRepository.clear();
    }

    @Test
    void 등록하기() {
        Mars mars = new Mars(1L,"jypark","경기도 평택시","10평");

        Long findmars = marsRepository.save(mars);

        assertThat(mars.getId()).isEqualTo(findmars);
    }

    @Test
    void 모두_조회하기(){
        Mars mars = new Mars(1L,"jypark","경기도 평택시","10평");
        Mars mars2 = new Mars(2L,"jypark","경기도 평택시","10평");

        marsRepository.save(mars);
        marsRepository.save(mars2);
        List<Mars> all_mars = marsRepository.findAll();

        assertThat(all_mars.size()).isEqualTo(2);
    }

}