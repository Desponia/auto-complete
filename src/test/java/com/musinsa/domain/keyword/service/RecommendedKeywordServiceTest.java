package com.musinsa.domain.keyword.service;

import com.musinsa.MusinsaApplication;
import com.musinsa.domain.keyword.entity.SearchKeyword;
import com.musinsa.domain.keyword.repository.RecommendedKeywordRepository;
import com.musinsa.infra.SearchKeywordJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = MusinsaApplication.class)
public class RecommendedKeywordServiceTest {

    RecommendedKeywordService recommendedKeywordService;
    private final RecommendedKeywordRepository recommendedKeywordRepository;
    private final SearchKeywordJpaRepository recommendedKeywordsJpaRepository;

    public RecommendedKeywordServiceTest(@Autowired SearchKeywordJpaRepository recommendedKeywordsJpaRepository,
                                         @Autowired RecommendedKeywordService recommendedKeywordService,
                                         @Autowired RecommendedKeywordRepository recommendedKeywordRepository) {
        this.recommendedKeywordsJpaRepository = recommendedKeywordsJpaRepository;
        this.recommendedKeywordService = recommendedKeywordService;
        this.recommendedKeywordRepository = recommendedKeywordRepository;
    }

    @BeforeEach
    void setUp() {
        recommendedKeywordService = new RecommendedKeywordService(recommendedKeywordRepository);

//        var keywords = List.of("nike ware", "hoodie nike", "nice jacket", "나이키", "나이키 운동화", "나이스한 레이스", "장우산 나이스롱", "아디다스", "아디다스 운동화");
//        keywords.forEach(key -> recommendedKeywordsJpaRepository.save(getRecommendedKeywords(key)));
    }

    @Test
    @DisplayName("라이크 검색이 되는지 보기")
    public void test1() {
        var keyword = "나이";
        var list = recommendedKeywordsJpaRepository.findByKeywordContaining(keyword);
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("라이크 검색이 되는지 보기2")
    public void test2() {
        var keyword = "나이";
        var list = recommendedKeywordRepository.getRecommendedKeywordsList(keyword);
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("라이크 검색이 되는지 보기3")
    public void test3() {
        var keyword = "나이";
        var list = recommendedKeywordService.getRecommendedKeywordsList(keyword);
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("라이크 검색이 되는지 보기4 eng")
    public void test4() {
        var keyword = "ni";
        var list = recommendedKeywordService.getRecommendedKeywordsList(keyword);
        assertEquals(6, list.size());
    }

    private SearchKeyword getRecommendedKeywords(String keyword) {
        SearchKeyword recommendedKeyword = new SearchKeyword();
        recommendedKeyword.setKeyword(keyword);

        return recommendedKeyword;
    }
}