package com.sample.blogapp.entities;

import lombok.*;
import org.springframework.lang.NonNull;
import javax.persistence.*;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    private String email;

    @Column(nullable = true)
    @NonNull
    private String bio;

    @Column(nullable = true)
    @NonNull
    private String image;
}
