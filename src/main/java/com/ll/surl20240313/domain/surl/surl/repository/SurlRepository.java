package com.ll.surl20240313.domain.surl.surl.repository;

import com.ll.surl20240313.domain.surl.surl.entity.Surl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurlRepository extends JpaRepository<Surl, Long> {
}