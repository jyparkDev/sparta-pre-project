package sparta.prestudy.movies;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    private final MongoTemplate mongoTemplate;

    public Long save(Movie movie){
        mongoTemplate.save(movie);
        return movie.getId();
    }

    public List<Movie> findAll(){
        return mongoTemplate.findAll(Movie.class);
    }
}
