package me.donghun.review;

import lombok.RequiredArgsConstructor;
import me.donghun.review.account.Account;
import me.donghun.review.account.AccountRepository;
import me.donghun.review.account.LoginType;
import me.donghun.review.genre.Genre;
import me.donghun.review.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@RequiredArgsConstructor
@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {

    private final GenreRepository genreRepository;

    private final AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};
//
//        for (String name : names) {
//            genreRepository.save(Genre.builder().name(name).build());
//        }
    }
}
