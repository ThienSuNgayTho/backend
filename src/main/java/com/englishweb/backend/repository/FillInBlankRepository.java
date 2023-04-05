package com.englishweb.backend.repository;

import com.englishweb.backend.entity.FillInBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FillInBlankRepository extends JpaRepository<FillInBlank, Long> {
    @Query(value = "select * from fill_in_blank where levelid =?1 order by rand() limit 5 ", nativeQuery = true)
    List<FillInBlank> findAllByLevelId(Long levelid);

    @Query(value = "select * from fill_in_blank where id =?1 ", nativeQuery = true)
    List<FillInBlank> findFillInBlanksById(Long id);
    
    @Modifying
    @Query(value = "INSERT INTO fill_in_blank (question, answer, levelid) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveFillInBlankByLevel(String question, String answer, Long levelId);

    @Query(value = "select * from fill_in_blank where levelid =?1 ", nativeQuery = true)
    List<FillInBlank> findAllFillInBlanksByLevelId(Long levelId);
}
