package com.ll.surl20240313.domain.surl.surl.service;

import com.ll.surl20240313.domain.surl.surl.entity.Surl;
import com.ll.surl20240313.domain.surl.surl.repository.SurlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurlService {

    private final SurlRepository surlRepository;

    public long count() {
        return surlRepository.count();
    }

    @Transactional
    public Surl create(String url, String title) {
        Surl surl = Surl.builder()
                .url(url)
                .title(title)
                .build();

        surlRepository.save(surl);

        return surl;
    }

    public Optional<Surl> findById(long id) {
        return surlRepository.findById(id);
    }

    @Transactional
    public void modify(long id, String title) {
        Surl surl = surlRepository.findById(id).get();
        surl.setTitle(title);
    }
}
