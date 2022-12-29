package sparta.prestudy.fans;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FansRepository {

    private final MongoTemplate mongoTemplate;

    public Long save(Fan fan){
        mongoTemplate.save(fan);
        return fan.getId();
    }

    public List<Fan> findAll(){
        return mongoTemplate.findAll(Fan.class);
    }

    public void clearAll(){
        mongoTemplate.dropCollection("fans");
    }
}
