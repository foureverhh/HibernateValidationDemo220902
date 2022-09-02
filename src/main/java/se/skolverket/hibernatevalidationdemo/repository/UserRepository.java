package se.skolverket.hibernatevalidationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.skolverket.hibernatevalidationdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
