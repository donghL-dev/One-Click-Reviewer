package me.donghun.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.donghun.review.account.Account;
import me.donghun.review.account.AccountRepository;
import me.donghun.review.account.LoginType;
import me.donghun.review.genre.Genre;
import me.donghun.review.genre.GenreRepository;
import me.donghun.review.movie.Movie;
import me.donghun.review.movie.MovieRepository;
import me.donghun.review.moviegenre.MovieGenre;
import me.donghun.review.moviegenre.MovieGenreRepository;
import me.donghun.review.mygenre.MyGenre;
import me.donghun.review.mygenre.MyGenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.io.File;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DirtiesContext
//@Transactional
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    protected GenreRepository genreRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected MyGenreRepository myGenreRepository;

    @Autowired
    protected MovieRepository movieRepository;

    @Autowired
    protected MovieGenreRepository movieGenreRepository;

    protected String email = "email@email.com";
    protected String password = "1q2w3e4r!";

    @BeforeEach
    void init() throws Exception {
//        myGenreRepository.deleteAll();
//        genreRepository.deleteAll();
//        accountRepository.deleteAll();

        String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};
        for (String name : names) {
            genreRepository.save(Genre.builder()
                    .name(name)
                    .build());
        }

        Account account = accountRepository.save(Account.builder()
                .email(email)
                .password(password)
                .loginType(LoginType.CREDENTIAL)
                .isVerified(false)
                .build());

        String[] str = {"공포", "SF"};
        for (String s : str) {
            Genre genre = genreRepository.findByName(s);
            MyGenre myGenre = MyGenre.builder()
                    .account(account)
                    .genre(genre)
                    .build();
//            account.getMyGenres().add(myGenre);
//            genre.getMyGenres().add(myGenre);
            myGenreRepository.save(myGenre);
        }

        initMovie();
    }

    void initMovie() throws Exception {
        Movie[] movies = objectMapper.readValue(new File("Movie.json"), Movie[].class);

        for(Movie movie : movies)  {
            Movie savedMovie = movieRepository.save(movie);
            for(Long id : movie.getMovieGenreIds()) {
                movieGenreRepository.save(MovieGenre.builder()
                        .genre(genreRepository.findById(id).get())
                        .movie(savedMovie)
                        .build());
            }
        }
    }
}
