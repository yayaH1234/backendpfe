package backendproj.demo.dao;


import backendproj.demo.model.testDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testrepo extends MongoRepository<testDoc, String> {
}
