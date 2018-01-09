package pl.cafebabe.demo.tweeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cafebabe.demo.tweeter.repository.TweetRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	private TweetRepository tweetRepository;

}