package sparta.prestudy.mars;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarsRepository {

    private final MongoTemplate mongoTemplate;

    public Long save(Mars mars){
        mongoTemplate.insert(mars);
        return mars.getId();
    }

    public List<Mars> findAll(){
        List<Mars> mars_list = mongoTemplate.findAll(Mars.class);
        return mars_list;
    }

    public void clear(){
        mongoTemplate.dropCollection("mars");
    }


}
