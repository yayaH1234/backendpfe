package backendproj.demo.service;

import backendproj.demo.dao.LocationRepos;
import backendproj.demo.dao.VendreRepository;
import backendproj.demo.model.Location;
import backendproj.demo.model.Vendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffaireService {
    @Autowired
    private LocationRepos location;


    @Autowired
    private VendreRepository vendreRepository;




    /// traitement de location


    public Location  findByLId(String id){
        return location.findById(id).get();
    }

    public void deleteByLId(String id){location.deleteById(id);
    }

    public void deleteAllL(){
        location.deleteAll();
    }

    public boolean updateL(Location lo){
        location.save(lo);
        return true;
    }

    public List<Location> findAllL(){
        return location.findAll();
    }

    ///  traitement de vent

    public Vendre findByVId(String id){
        return vendreRepository.findById(id).get();
    }

    public void deleteByVId(String id){vendreRepository.deleteById(id);
    }

    public void deleteAllV(){
        vendreRepository.deleteAll();
    }

    public boolean updateV(Vendre lo){ vendreRepository.save(lo);
    return true;
    }

    public List<Vendre> findAllV(){
        return vendreRepository.findAll();
    }

}
