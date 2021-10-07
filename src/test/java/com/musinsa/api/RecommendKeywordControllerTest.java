package com.musinsa.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.domain.keyword.entity.SearchKeyword;
import com.musinsa.domain.keyword.service.RecommendedKeywordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RecommendKeywordControllerTest {
    private MockMvc mvc;
    private RecommendedKeywordService recommendedKeywordService;

    @BeforeEach
    void setUp() {
        recommendedKeywordService = mock(RecommendedKeywordService.class);
        mvc = MockMvcBuilders.standaloneSetup(
                new RecommendKeywordController(recommendedKeywordService))
                .build();
    }

    @Test
    public void test1() throws Exception {
        var keywords = List.of("nike ware", "hoodie nike", "nice jacket");

        given(recommendedKeywordService.getRecommendedKeywordsList(any()))
                .willReturn(keywords.stream().map(key -> {
                    var searchKeyword = new SearchKeyword();
                    searchKeyword.setKeyword(key);
                    return searchKeyword;
                }).collect(Collectors.toList()));

        perform(get("/search/auto-complete/{keyword}", "ni"))
                .andExpect(status().isOk());
    }

    private ResultActions perform(MockHttpServletRequestBuilder accept) throws Exception {
        return mvc.perform(accept);
    }

}