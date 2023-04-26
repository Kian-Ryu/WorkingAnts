package com.Allchat.model;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends CrudRepository<Messagerepo, Long> {

	Optional<Messagerepo> findById(Long id);   
    // Optional은 null 방지용으로 작성됨 
    
}