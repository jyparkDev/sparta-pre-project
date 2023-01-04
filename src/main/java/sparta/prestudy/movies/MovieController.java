package sparta.prestudy.movies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MoviesService moviesService;

    @GetMapping("/movies")
    public String createForm(){
        return "movies/main";
    }

    @GetMapping("/movies/movies")
    @ResponseBody
    public Map<String, List<Movie>> findAll(){
        Map<String, List<Movie>> movies = new HashMap<>();
        List<Movie> movieList = moviesService.findMovies();
        movies.put("movies",movieList);
        return movies;
    }

    @PostMapping("/movies/save")
    @ResponseBody
    public Map<String,String> create(@ModelAttribute Movie movie){
        Map<String,String> result = new HashMap<>();

        try{
            moviesService.join(movie.getUrl(),movie);
            result.put("msg","등록완료!");
        }catch (IOException e){
            result.put("msg","해당 영화는 없습니다");
        }
        return result;
    }
}
