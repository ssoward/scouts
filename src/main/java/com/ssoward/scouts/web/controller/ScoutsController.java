package com.ssoward.scouts.web.controller;


import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: ssoward
 * Date: 1/14/14
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/api")
public class ScoutsController {


    @RequestMapping(method = RequestMethod.GET, value="/scouts", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getscout(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return "hello world, you must be a scout or at least have the right permissions."; //new ResponseEntity<>("hello scout", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/leaders", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> leader(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return new ResponseEntity<>("hello leader", HttpStatus.OK);
    }


    String scout;

    public String getScout() {
        return scout;
    }

    public void setScout(String scout) {
        this.scout = scout;
    }
}
