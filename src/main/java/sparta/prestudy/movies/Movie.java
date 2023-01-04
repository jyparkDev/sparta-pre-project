package sparta.prestudy.movies;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter @Setter
@ToString
@Document("movies")
@AllArgsConstructor
public class Movie {

    @Id
    private Long id;

    private String title;

    private String image;
    private String desc;
    private String star;
    private String comment;
    private String url;

}
