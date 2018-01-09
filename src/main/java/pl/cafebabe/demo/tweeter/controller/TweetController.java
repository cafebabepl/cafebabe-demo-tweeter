package pl.cafebabe.demo.tweeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.cafebabe.demo.tweeter.model.Tweet;
import pl.cafebabe.demo.tweeter.model.User;
import pl.cafebabe.demo.tweeter.repository.TweetRepository;
import pl.cafebabe.demo.tweeter.repository.UserRepository;

@Controller
public class TweetController {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/tweet/add")
	public String tweetAddForm(Model model) {
		model.addAttribute("tweet", new Tweet());
		List<User> users = userRepository.findAll(new Sort(Direction.ASC, "lastName", "firstName"));
		model.addAttribute("users", users);
		return "tweet-add";
	}

	@GetMapping("/user/search-tweets")
	public String userSearchTweetsForm() {
		return "user-search-tweets";
	}
	
	@PostMapping("/user/search-tweets")
	public String userSearchTweetsSubmit(Model model, @RequestParam(name = "title", required = true) String title) {
		List<Tweet> tweets = tweetRepository.findTweetsByTitleStartingWithIgnoreCaseOrderByCreatedDesc(title);
		model.addAttribute("tweets", tweets);
		return "user-search-tweets";
	}

}