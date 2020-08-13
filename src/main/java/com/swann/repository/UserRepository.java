package com.swann.repository;

import com.swann.entity.UserPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserPost, Long> {
    UserPost findByUserIdentifier(String userIdentifier);

    @Override
    Iterable<UserPost> findAll();
}
