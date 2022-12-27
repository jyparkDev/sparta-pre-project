package sparta.prestudy.fans;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FansService {

    private final FansRepository fansRepository;

    public Long createFan(Fan fan){
        Long id = (long)fansRepository.findAll().size() + 1;
        fan.setId(id);
        return fansRepository.save(fan);
    }

    public List<Fan> findFans(){
        return fansRepository.findAll();
    }

    public void removeAll(){
        fansRepository.clearAll();
    }
}
