package com.zillionsoftech.org.repositories;

import com.zillionsoftech.org.entities.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, String> {

    Optional<Users> findByUserIdIgnoreCase(String userId);
}
