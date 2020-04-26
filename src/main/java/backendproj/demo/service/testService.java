package backendproj.demo.service;

import backendproj.demo.dao.testrepo;
import backendproj.demo.model.testDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testService {
    @Autowired
    private testrepo testRep;


    public testDoc findById(String id){
        return testRep.findById(id).get();
    }

    public void deleteById(String id){
        testRep.deleteById(id);
    }

    public void deleteAllUser(){
        testRep.deleteAll();
    }

    public void updateuser(testDoc cl){
        testRep.save(cl);
    }

    public List<testDoc> findAll(){
        return testRep.findAll();
    }

}
