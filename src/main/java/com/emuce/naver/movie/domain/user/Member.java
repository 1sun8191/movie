package com.emuce.naver.movie.domain.user;

import com.emuce.naver.movie.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

//    @OneToMany(mappedBy = "member")
//    private List<Review> reviews;


}
