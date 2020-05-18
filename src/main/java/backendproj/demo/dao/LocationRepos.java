package backendproj.demo.dao;

import backendproj.demo.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepos  extends MongoRepository<Location, String> {
}
