package com.company.service;

import com.company.dto.MerchantDTO;
import com.company.dto.request.MerchantRequestDTO;
import com.company.dto.request.MerchantUpdateDetailDTO;
import com.company.dto.response.CardResponseDTO;
import com.company.entity.MerchantEntity;
import com.company.enums.MerchantStatus;
import com.company.exception.AppBadRequestException;
import com.company.exception.AppForbiddenException;
import com.company.exception.ItemAlreadyExistsException;
import com.company.repository.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttachService attachService;

    public MerchantDTO create(MerchantRequestDTO dto) {
        RestTemplate restTemplate = new RestTemplate();
        Optional<MerchantEntity> optional = merchantRepository.findByNameAndStatus(dto.getName(), MerchantStatus.ACTIVE);
        if (optional.isPresent()) {
            log.warn("Merchant name already Exists {} {}", dto.getName(), MerchantService.class);
            throw new ItemAlreadyExistsException("Merchant name already Exists");
        }
        categoryService.get(dto.getCategoryId());
        MerchantEntity entity = new MerchantEntity();
        try {
            CardResponseDTO cardDTO = restTemplate.getForObject("https://uzcard01.herokuapp.com/card/card/" + dto.getCardNumber(), CardResponseDTO.class);
            if (!dto.getPhone().equals(cardDTO.getPhone())) {
                log.warn("Not access {}", MerchantService.class);
                throw new AppForbiddenException("Not access");
            }

            entity.setName(dto.getName());
            entity.setCardNumber(dto.getCardNumber());
            entity.setCategoryId(dto.getCategoryId());
            entity.setPhone(dto.getPhone());
            String pswd = DigestUtils.md5Hex(dto.getPassword());
            entity.setPassword(pswd);
            entity.setVisible(true);
            entity.setStatus(MerchantStatus.ACTIVE);
            if (dto.getAttachId() != null) {
                attachService.get(dto.getAttachId());
                entity.setAttachId(dto.getAttachId());
            }
            entity.setParsentage(dto.getParsentage());
            merchantRepository.save(entity);
            return toDTO(entity);
        } catch (HttpClientErrorException e) {
            log.warn("Card not found {} {}", dto.getCardNumber(), CardService.class);
            throw new AppBadRequestException("Card Not Found");
        }
    }

    public Boolean updateName(String merchantId, MerchantUpdateDetailDTO dto) {

        return false;
    }

    public Boolean updateParsentage(String merchantId, MerchantUpdateDetailDTO dto) {
        return false;
    }

    public Boolean updateStatus(String merchantId, MerchantStatus status) {
        return false;
    }

    public Boolean updateCard(String merchantId, MerchantUpdateDetailDTO card) {
        return false;
    }

    public Boolean updatedCategory(String merchantId, MerchantUpdateDetailDTO category) {
        return false;
    }

    public Boolean delete(String merchantId) {
        return false;
    }


    public PageImpl<MerchantDTO> getList(int page, int size) {
        return null;
    }

    public MerchantDTO toDTO(MerchantEntity entity) {
        MerchantDTO dto = new MerchantDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setParsentage(entity.getParsentage());
        if (entity.getAttachId() != null) {
            dto.setAttachDTO(attachService.toOpenURLDTO(entity.getAttachId()));
        }
        dto.setCardNumber(entity.getCardNumber());
        dto.setCategoryId(entity.getCategoryId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
}
