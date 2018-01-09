package pl.cafebabe.demo.tweeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cafebabe.demo.tweeter.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
