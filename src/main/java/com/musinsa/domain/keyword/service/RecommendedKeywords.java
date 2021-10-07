package com.musinsa.domain.keyword.service;

import com.musinsa.domain.keyword.entity.SearchKeyword;
import lombok.Builder;
import lombok.Value;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Value
@Builder
public class RecommendedKeywords {
    List<String> recommendedKeywords;

    public static RecommendedKeywords of(List<SearchKeyword> keywords) {
        return RecommendedKeywords.builder()
                .recommendedKeywords(keywords.stream()
                        .sorted(Comparator.comparingInt(o -> o.getKeyword().length()))
                        .map(SearchKeyword::getKeyword)
                        .collect(Collectors.toList()))
                .build();
    }
}
