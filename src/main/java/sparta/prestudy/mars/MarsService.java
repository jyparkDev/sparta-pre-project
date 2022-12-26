package sparta.prestudy.mars;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarsService {

    private final MarsRepository marsRepository;

    public Long join(Mars mars){
        Long id = (long)marsRepository.findAll().size()+1;
        mars.setId(id);
        return marsRepository.save(mars);
    }

    public List<Mars> findMars(){
        return marsRepository.findAll();
    }
}
