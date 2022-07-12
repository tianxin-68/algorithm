package bull.spring.web;

import bull.spring.web.common.RestResult;
import bull.spring.web.vo.QueryVo;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    public static void main(String[] args) {
        SpringApplication.run(DemoController.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping("/body")
    public Object body(@RequestBody QueryVo param) {
        return RestResult.ok(param);
    }
}