package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "select id, actor, detail " +
            "from scripts " +
            "order by rand() limit 1", nativeQuery = true)
    Quote getQuote();

    @Query(value = "select id, actor, detail " +
            "from scripts where actor LIKE :actor " +
            "order by rand() limit 1", nativeQuery = true)
    Quote getQuoteByActor(@Param("actor") String actor);

}
