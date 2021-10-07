package com.musinsa.api;

import com.musinsa.domain.keyword.service.RecommendedKeywordService;
import com.musinsa.domain.keyword.service.RecommendedKeywords;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class RecommendKeywordController {

    private final RecommendedKeywordService recommendedKeywordService;

    @GetMapping("/auto-complete/{keyword}")
    public RecommendedKeywords getRecommendedKeywords(@PathVariable(name = "keyword") String keyword) {
        return RecommendedKeywords.of(recommendedKeywordService.getRecommendedKeywordsList(keyword));
    }
}
