package com.musinsa.domain.keyword.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "search_keyword")
public class SearchKeyword {

    @Id
    @Column(name = "keyword")
    private String keyword;
}
