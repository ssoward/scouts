package com.ssoward.scouts.web.controller;


import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ScoutsController {


    @RequestMapping(method = RequestMethod.GET, value="/scouts", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> getscout(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
//        System.out.println("scout:"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new ResponseEntity<>("hello scout", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/leaders", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> leader(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
//        System.out.println("leader:"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new ResponseEntity<>("hello leader", HttpStatus.OK);
    }
}
