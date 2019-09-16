package it.lupatellihaus.myamazinglibrary.controller;

import it.lupatellihaus.myamazinglibrary.domain.Author;
import it.lupatellihaus.myamazinglibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/author") // This means URL's start with /demo (after controller.Application path)
public class AuthorController {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
//	private AuthorRepository authorRepository;
    @Autowired
	AuthorService authorService;

    @PostMapping // Map ONLY POST Requests
    public @ResponseBody
	Author addNewAuthor(@RequestBody Author authorInput) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return authorService.createAuthor(authorInput);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Author> getAllAuthors() {
        // This returns a JSON or XML with the users
        return authorService.findAuthors();
    }

    @GetMapping(path = "/{lastName}")
    public @ResponseBody
    Author getAuthorByLastname(@PathVariable String lastName) throws Exception {
        return authorService.findAuthorByLastName(lastName);
    }
}