package me.donghun.review.genre;

import lombok.*;
import me.donghun.review.moviegenre.MovieGenre;
import me.donghun.review.mygenre.MyGenre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENRE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private final Set<MyGenre> myGenres = new HashSet<>();

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private final Set<MovieGenre>  movieGenres = new HashSet<>();

}
