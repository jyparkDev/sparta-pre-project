package sparta.prestudy.movies;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import java.io.IOException;
class MovieServiceTest {


    @Test
    void 크롤링() throws IOException {
        String url = "https://movie.naver.com/movie/bi/mi/basic.naver?code=18";
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();
        String title = doc.select("meta[property='og:title']").attr("content");
        if (title.equals(""))
            throw new IOException("해당 영화는 존재하지 않습니다");
        String img = doc.select("meta[property='og:images']").attr("content");
        String desc = doc.select("meta[property='og:description']").attr("content");
    }


}