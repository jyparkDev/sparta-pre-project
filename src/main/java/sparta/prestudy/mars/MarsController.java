package sparta.prestudy.mars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarsController {

    @GetMapping("/mars")
    public String marsMain(){
        return "mars/main";
    }
}
