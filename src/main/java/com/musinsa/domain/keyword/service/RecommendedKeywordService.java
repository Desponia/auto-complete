package com.musinsa.domain.keyword.service;

import com.musinsa.domain.keyword.entity.SearchKeyword;
import com.musinsa.domain.keyword.repository.RecommendedKeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendedKeywordService {
    private final RecommendedKeywordRepository recommendedKeywordRepository;

    public List<SearchKeyword> getRecommendedKeywordsList(String keyword) {
        return recommendedKeywordRepository.getRecommendedKeywordsList(keyword);
    }
}
