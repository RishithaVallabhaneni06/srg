package jar.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class F {
    @GetMapping("/f")
    public Map<Object,Object> m()
    {
        Map<Object,Object> res=new HashMap<>();
        res.put("api","fruits end point");
        res.put("mango","MM");
        res.put("apple","AA");
        res.put("f","FRUITS");
        
        return res;
    }
}
