package pl.cafebabe.demo.tweeter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Autowired
	Validator validator;	

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
	public String userAdd(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@GetMapping("/edit/{id}")
	public String userEdit(Model model, @PathVariable Long id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "user-form";
	}
	
	@PostMapping("/save")
	public String userSave(@ModelAttribute @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-form";
		} else {
			userRepository.save(user);
			return "redirect:/user/all";
		}
	}

}