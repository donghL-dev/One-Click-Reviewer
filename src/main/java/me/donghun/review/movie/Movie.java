package me.donghun.review.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.donghun.review.moviegenre.MovieGenre;
import me.donghun.review.mygenre.MyGenre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long idx;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    @Column
    private String nation;

    @Column
    private Integer runningTime;

    @Column
    private LocalDate openingDate;

    @Column
    private String imageUrl;

    @Transient
    private final Set<Long> movieGenreIds = new HashSet<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private final Set<MovieGenre> movieGenres = new HashSet<>();
}
