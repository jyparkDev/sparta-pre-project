package sparta.prestudy.bucket;

import com.mongodb.client.result.UpdateResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BucketRepositoryTest {

    @Autowired BucketRepository bucketRepository;

    @BeforeEach
    void beforeEach(){
        bucketRepository.clearAll();
    }
    @Test
    void 등록하기() {
        Bucket bucket = new Bucket("취뽀하기");
        bucket.setId(1L);
        Long findId = bucketRepository.save(bucket);

        assertThat(findId).isEqualTo(0L);
    }

    @Test
    void 모두_조회하기() {
        Bucket bucket = new Bucket("취뽀하기");
        bucket.setId(1L);
        Bucket bucket2 = new Bucket("취뽀하기");
        bucket2.setId(2L);

        bucketRepository.save(bucket);
        bucketRepository.save(bucket2);

        List<Bucket> findAll = bucketRepository.findAll();

        assertThat(findAll.size()).isEqualTo(2);
    }

    @Test
    void ID_받아와서_등록하기(){
        Long id = (long)bucketRepository.findAll().size() + 1;
        Bucket bucket = new Bucket("취뽀하기");
        bucket.setId(id);

        Long findId = bucketRepository.save(bucket);

        assertThat(findId).isEqualTo(id);
    }
    
    @Test
    void 완료하기(){
        Bucket bucket = new Bucket("수정 테스트하기");
        bucket.setId(1L);
        Long result = bucketRepository.save(bucket);

        Long updateResult = bucketRepository.updateBucket(result);

        assertThat(updateResult).isEqualTo(result);
        
    }
}