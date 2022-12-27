package sparta.prestudy.fans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("fans")
@Getter @Setter
@AllArgsConstructor
@ToString
public class Fan {

    @Id
    private Long id;

    private String name;
    private String comment;

}
