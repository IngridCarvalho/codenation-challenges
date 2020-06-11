package challenge;

import java.util.List;

public interface QuoteService {

	Quote getQuote();
	
	Quote getQuoteByActor(String actor);

}
