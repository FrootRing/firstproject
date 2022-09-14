package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor//디폴트 생성자
@Getter
public class Article {

    @Id //대표값지정
    @GeneratedValue //자동생성 어노테이션
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

}
