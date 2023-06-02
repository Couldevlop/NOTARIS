package com.notaris.soro.services;

import com.notaris.soro.dto.BanqueDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BanqueService {
    BanqueDTO save( MultipartFile file,BanqueDTO dto) throws IOException;
    BanqueDTO create(BanqueDTO dto);
    BanqueDTO findById(Integer id);
    List<BanqueDTO> findAll();
    BanqueDTO findBySigle(String sigle);
    void delete(Integer id);
}
