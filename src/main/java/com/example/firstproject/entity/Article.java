package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

}