package pl.cafebabe.demo.tweeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cafebabe.demo.tweeter.model.User;
import pl.cafebabe.demo.tweeter.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/all")
	public String userAll(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "user-all";
	}
	
	@RequestMapping("/delete/{id}")
	public String userDelete(@PathVariable long id) {
		userRepository.delete(id);
		return "redirect:/user/all";
	}

	@GetMapping("/add")
	public String userAddForm(Model model) {
		model.addAttribute("user", new User());
		return "user-add";
	}

	@PostMapping("/add")
	public String userAddSubmit() {
		return "redirect:/user/all";
	}

}