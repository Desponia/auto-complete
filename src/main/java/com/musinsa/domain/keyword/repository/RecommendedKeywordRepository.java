package com.musinsa.domain.keyword.repository;

import com.musinsa.domain.keyword.entity.SearchKeyword;

import java.util.List;

public interface RecommendedKeywordRepository {
    List<SearchKeyword> getRecommendedKeywordsList(String keyword);
}
