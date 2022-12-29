package sparta.prestudy.bucket;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BucketController {

    private final BucketService bucketService;

    @GetMapping("/bucket")
    public String createForm(){
        return "/bucket/main";
    }

    @PostMapping("/bucket/save")
    @ResponseBody
    public Map<String,String> create(Bucket bucket){
        Map<String,String> result = new HashMap<>();
        Long bucketId = bucketService.createBucket(bucket);
        result.put("msg",bucketId+"번 버킷 등록완료!!");
        return result;
    }

    @GetMapping("/bucket/bucket")
    @ResponseBody
    public Map<String, List<Bucket>> findAllBucket(){
        Map<String,List<Bucket>> result = new HashMap<>();
        List<Bucket> buckets = bucketService.findBuckets();
        result.put("buckets",buckets);
        return result;
    }

    @PostMapping("/bucket/done")
    @ResponseBody
    public Map<String,String> done(Done done){
        Map<String,String> result = new HashMap<>();
        Long doneId = done.getNum();
        bucketService.done(doneId);
        result.put("msg","완료!!");
        return result;
    }
}
