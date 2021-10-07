package com.musinsa.infra;

import com.musinsa.domain.keyword.entity.SearchKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchKeywordJpaRepository extends JpaRepository<SearchKeyword, Long> {
    List<SearchKeyword> findByKeywordContaining(String keyword);
}
