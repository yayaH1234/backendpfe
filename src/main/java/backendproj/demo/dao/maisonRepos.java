package backendproj.demo.dao;

import backendproj.demo.model.Maison;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface maisonRepos extends MongoRepository<Maison, String> {
}
