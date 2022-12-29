package sparta.prestudy.bucket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BucketService {
    private final BucketRepository bucketRepository;

    public Long createBucket(Bucket bucket){
        Long id = (long)bucketRepository.findAll().size() + 1;
        bucket.setId(id);
        return bucketRepository.save(bucket);
    }

    public List<Bucket> findBuckets(){
        return bucketRepository.findAll();
    }

    public Long done(Long id){
        return bucketRepository.updateBucket(id);
    }
}
