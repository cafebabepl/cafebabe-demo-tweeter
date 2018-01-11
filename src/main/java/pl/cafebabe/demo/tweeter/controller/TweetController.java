package pl.cafebabe.demo.tweeter.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@Autowired
	Validator validator;	

	@ModelAttribute(name = "users")
	public List<User> users() {
		List<User> users = userRepository.findAll(new Sort(Direction.ASC, "lastName", "firstName"));
		return users;
	}

	@GetMapping("/tweet/add")
	public String tweetAdd(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "tweet-form";
	}

	@PostMapping("/tweet/save")
	public String tweetSave(@ModelAttribute @Valid Tweet tweet, BindingResult result) {
		if (result.hasErrors()) {
			return "tweet-form";
		} else {
			tweet.setCreated(new Date());
			tweetRepository.save(tweet);
			// przekierowanie na tweety użytkownika
			return String.format("redirect:/user/%d/tweets", tweet.getUser().getId());
		}
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
	
	@Transactional(readOnly = true)
	@RequestMapping("/user/{id}/tweets")
	public String userTweets(Model model, @PathVariable(name = "id", required = true) Long id) {
		User user = userRepository.getOne(id);
		user.getTweets().size();
		model.addAttribute("user", user);
		return "user-tweets";
	}
}