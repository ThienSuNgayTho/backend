package com.englishweb.backend.repository;

import com.englishweb.backend.entity.FillInBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FillInBlankRepository extends JpaRepository<FillInBlank, Long> {
    @Query(value = "SELECT * FROM fill_in_blank WHERE levelid = ?1", nativeQuery = true)
    List<FillInBlank> findAllByLevelId(Long levelid);
}
