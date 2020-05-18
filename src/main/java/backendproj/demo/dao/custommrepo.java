package backendproj.demo.dao;

import backendproj.demo.model.User;
import backendproj.demo.model.custommer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface custommrepo extends MongoRepository<custommer, String> {
}
