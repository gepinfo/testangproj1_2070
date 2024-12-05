package com.geppetto.testangproj1.repository;

import com.geppetto.testangproj1.model.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface UserRepository extends MongoRepository<User, String>  {
    
    Page<User> findAll(Pageable pageable);

}