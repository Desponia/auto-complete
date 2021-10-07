package com.musinsa.domain.keyword.repository;

import com.musinsa.domain.keyword.entity.SearchKeyword;
import com.musinsa.infra.SearchKeywordJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecommendedKeywordRepositoryImpl implements RecommendedKeywordRepository {
    private final SearchKeywordJpaRepository searchKeywordsJpaRepository;

    @Override
    public List<SearchKeyword> getRecommendedKeywordsList(String keyword) {
        return searchKeywordsJpaRepository.findByKeywordContaining(keyword);
    }
}
