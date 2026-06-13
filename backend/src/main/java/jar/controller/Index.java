package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @GetMapping("/")
    public Map<Object, Object> m1() {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "spring boot server");
        res.put("server", "running sucesss ✅");
        res.put("status", 200);
        return res;
    }

}
