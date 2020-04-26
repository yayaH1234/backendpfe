package backendproj.demo.controller;

import backendproj.demo.model.testDoc;
import backendproj.demo.service.testService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/test")

public class testController {
    @Autowired
    private testService userServ;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    @GetMapping(value="/test")
    public String test(){
        return "true";
    }
    @PostMapping(value="/add")
    public void ajoute(@RequestParam("msg") String ms,@RequestParam("id")  String id){
        userServ.updateuser(new testDoc(id,ms));
    }
    @GetMapping(value="/ok/{id}")
    public testDoc rjr(@PathVariable String id){
        return userServ.findById(id);
    }

    @GetMapping(value="/ok")
    public List<testDoc> findAll(){
        return userServ.findAll();
    }
}
