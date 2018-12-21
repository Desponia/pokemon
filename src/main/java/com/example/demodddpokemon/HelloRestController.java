package com.example.demodddpokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

//    SpringWebMVC 덕분에 아래의 글자가 화면에 노출되는 거임.
    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";
    }

}
