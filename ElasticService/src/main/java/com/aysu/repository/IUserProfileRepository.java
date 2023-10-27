package com.aysu.repository;

import com.aysu.repository.entity.UserProfile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile, Long> {

    boolean existsUserProfileById(Long id);
}
