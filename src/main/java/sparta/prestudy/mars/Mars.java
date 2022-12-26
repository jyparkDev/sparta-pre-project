package sparta.prestudy.mars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Getter @Setter
@Document("mars")
@AllArgsConstructor
@ToString
public class Mars {

    @Id
    private Long id;

    private String name;
    private String address;
    private String size;

}
