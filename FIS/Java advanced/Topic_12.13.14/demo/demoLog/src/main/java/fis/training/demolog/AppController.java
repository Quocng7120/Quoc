package fis.training.demolog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppController {
    Logger log = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello/{name}")
    @ResponseBody
    public ResponseEntity<?> hello(@PathVariable String name){
        System.out.println("123");
        log.info("123");
        log.info("info: hello, {}", name);
        log.debug("Debug: hello, {}", name);
        log.warn("Warn: Hello, {}", name);

        return ResponseEntity.ok("Hello, " + name);
    }
}
