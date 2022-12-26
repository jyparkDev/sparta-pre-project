package sparta.prestudy.mars;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MarsController {

    private final MarsService marsService;

    @GetMapping("/mars")
    public String createFrom() {
        return "mars/main";
    }

    @GetMapping("/mars/mars")
    @ResponseBody
    public Map<String , List<Mars>> findAll() {
        Map<String , List<Mars>> orders = new HashMap<>();
        List<Mars> marsList = marsService.findMars();
        orders.put("orders",marsList);
        return orders;
    }
    @PostMapping("/mars/save")
    @ResponseBody
    public Map<String, String> create(@ModelAttribute Mars mars){
        Map<String,String> msg = new HashMap<>();
        Long marsId = marsService.join(mars);
        msg.put("msg","등록완료");
        return msg;
    }



}
