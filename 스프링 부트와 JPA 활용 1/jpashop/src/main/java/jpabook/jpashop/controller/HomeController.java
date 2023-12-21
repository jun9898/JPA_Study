package jpabook.jpashop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        log.info("home controller");
        return "home";
    }
}
