package sparta.prestudy.movies;

import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MoviesService {

    private final MovieRepository movieRepository;
    public Long join(String url, Movie movie) throws IOException{
        Map<String,String> movieInfo = crawling(url);
        long id = (long)movieRepository.findAll().size()+1;
        movie.setId(id);
        movie.setTitle(movieInfo.get("title"));
        movie.setDesc(movieInfo.get("desc"));
        movie.setImage(movieInfo.get("img"));
        System.out.println(movie);
        return movieRepository.save(movie);
    }

    public List<Movie> findMovies(){
        return movieRepository.findAll();
    }
    private Map<String,String> crawling(String url) throws IOException{
        Map<String,String> movieInfo ;
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();
        String title = doc.select("meta[property='og:title']").attr("content");
        if (title.equals(""))
            throw new IOException("해당 영화는 존재하지 않습니다");
        String img = doc.select("meta[property='og:image']").attr("content");
        String desc = doc.select("meta[property='og:description']").attr("content");
        movieInfo = new HashMap<>();
        movieInfo.put("title",title);
        movieInfo.put("img",img);
        movieInfo.put("desc",desc);
        return movieInfo;
    }
}
