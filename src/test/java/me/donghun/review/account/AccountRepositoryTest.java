package me.donghun.review.account;

import me.donghun.review.BaseControllerTest;
import me.donghun.review.mygenre.MyGenre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest extends BaseControllerTest {
    @DisplayName("Account를 조회하는 테스트")
    @Test
    void findByEmailTest() {
        Account account = accountRepository.findByEmail(email);
        Set<MyGenre> myGenres = myGenreRepository.findByAccount(account);
//        Set<MyGenre> genres = account.getMyGenres();
        for (MyGenre genre : myGenres) {
            assertThat(genre.getAccount().getEmail()).isEqualTo(email);
        }
        assertThat(myGenres.size()).isNotNull();
    }
}
