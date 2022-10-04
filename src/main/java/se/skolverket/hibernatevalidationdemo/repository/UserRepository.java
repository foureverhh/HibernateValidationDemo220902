package se.skolverket.hibernatevalidationdemo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.skolverket.hibernatevalidationdemo.model.User;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Iterable<User> findAll(Sort sort);
    List<User> findByJobContaining(String job, Sort sort);
}
