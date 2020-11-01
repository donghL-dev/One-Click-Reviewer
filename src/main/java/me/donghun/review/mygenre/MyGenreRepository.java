package me.donghun.review.mygenre;

import me.donghun.review.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MyGenreRepository extends JpaRepository<MyGenre, Long> {
    Set<MyGenre> findByAccount(Account account);
}
