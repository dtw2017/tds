package com.example.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.readinglist.UserRepository;
import com.example.readinglist.BookingRepository;

import java.util.List;
import com.example.readinglist.User;
import com.example.readinglist.Booking;

@Controller
@RequestMapping("/")

public class ReadingListController {
	private ReadingListRepository readingListRepository;
	private HouseBLRepository houseblrepository;

	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	};

	@Autowired
	private BookingRepository bookingRepository;

	public @ResponseBody String addBooking(@RequestParam Booking booking) {
		Booking b = new Booking();
		bookingRepository.save(b);
		return "Saved";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/{reader}";
	}

	public String addBooking(String bookingno) {
		Booking n = new Booking();
		n.setBookingno(bookingno);
		return "Saved";
	}

	/* success
	@GetMapping(path = "/test222")
	public String UserShow(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("users", userRepository.findByName("marco"));
		return "test222";
	}
*/

	
	@GetMapping(path = "/test222")
	public String UserShow(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		return "test222";
	}
	
	@PostMapping(path = "/newbooking")
	public String newUser(String name, String email) {
		return "redirect:/newbooking";
	}

	@GetMapping("/booking")
	public String getUserByName(@RequestParam("name") String name, Model model) {
		model.addAttribute("booking", userRepository.findByName(name));
		return "booking";
	}

	/* User operation */
	@Autowired
	private UserRepository userRepository;// This means to get the bean called
											// userRepository
	// Which is auto-generated by Spring, we will use it to handle the data

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		System.out.println("requst from ajax");
		return userRepository.findAll();
	}

	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	// find specific user, success
	@GetMapping(value = "/getuserinfo")
	@ResponseBody
	public Iterable<User> getuserinfo() {
		return userRepository.findByName("ddd");
	}

	// success, access /getuser?name=username
	@GetMapping(value = "/getuser") // @RequsetMapping method=RquesGet
	public @ResponseBody Iterable<User> getuser(@RequestParam("name") String name) {
		return userRepository.findByName(name);
	}

	@RequestMapping("/saveuserinfo") // Post and Get both needed
	@ResponseBody
	public User saveuserinfo(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return n;
	}

	@RequestMapping("/deleteuser")
	@ResponseBody
	public Iterable<User> deleteuser(@RequestParam String name) throws Exception {
		// User n = new User();
		// n.setName(name);
		// n.setEmail(email);
		try {
			// userRepository.delete(n);
			userRepository.deleteByName(name);
			System.out.println("done");
		} catch (Exception e) {
			System.out.println("fail");
		}
		;
		return null;
	}

	@RequestMapping("/deleteall")
	@ResponseBody
	public Iterable<User> deleall() {
		userRepository.deleteAll();
		return null;
	}

	@ModelAttribute("allusers")
	public Iterable<User> allUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/filing")
	public String Filing() {
		return "filing";
	}
	
}