package sparta.prestudy.bucket;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("buckets")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Bucket {

    @Id
    private Long id;
    @NonNull
    private String bucket;

    private boolean done;
}
