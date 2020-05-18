package backendproj.demo.dao;

import backendproj.demo.model.Vendre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendreRepository extends MongoRepository<Vendre, String> {
}
