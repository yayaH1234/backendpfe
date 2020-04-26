package backendproj.demo.service;

import backendproj.demo.dao.maisonRepos;
import backendproj.demo.model.Maison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaisonService {
    @Autowired
    private maisonRepos maisonRepo;

    public List<Maison> findAllM(){
        return maisonRepo.findAll();
    }



}
