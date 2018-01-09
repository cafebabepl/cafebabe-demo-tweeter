package pl.cafebabe.demo.tweeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cafebabe.demo.tweeter.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
