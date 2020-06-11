package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

	@Autowired
	private QuoteService service;

	@GetMapping
	public Quote getQuote() {
		return service.getQuote();
	}

	@GetMapping(path = "/{actor}")
	public Quote getQuoteByActor(@PathVariable String actor) {
		return service.getQuoteByActor(actor);
	}

}
