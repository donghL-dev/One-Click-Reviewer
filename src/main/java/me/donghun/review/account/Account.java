package me.donghun.review.account;

import lombok.*;
import me.donghun.review.genre.Genre;
import me.donghun.review.mygenre.MyGenre;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column
    private Boolean isVerified;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private final Set<MyGenre> myGenres = new HashSet<>();

}
