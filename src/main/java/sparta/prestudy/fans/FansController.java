package sparta.prestudy.fans;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FansController {

    private final FansService fansService;

    @GetMapping("/fans")
    public String createForm(){
        return "fans/main";
    }

    @PostMapping("/fans/save")
    @ResponseBody
    public Map<String,String> create(@ModelAttribute Fan fan){
        Map<String,String> result = new HashMap<>();
        Long id = fansService.createFan(fan);
        result.put("msg", id+". 등록완료");
        return result;
    }

    @GetMapping("/fans/fans")
    @ResponseBody
    public Map<String, List<Fan>> findAll(){
        Map<String,List<Fan>> result = new HashMap<>();
        List<Fan> fanList = fansService.findFans();
        result.put("comment",fanList);
        return result;
    }

}
