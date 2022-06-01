package com.company.controller;

import com.company.dto.MerchantDTO;
import com.company.dto.request.MerchantRequestDTO;
import com.company.dto.request.MerchantUpdateDetailDTO;
import com.company.enums.MerchantStatus;
import com.company.enums.ProfileRole;
import com.company.service.MerchantService;
import com.company.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/merchant")
@Api(tags = "Merchant")
@Slf4j
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @ApiOperation(value = "Create merchant", notes = "Method used for create merchant for admin", nickname = "Bilol")
    @PostMapping("")
    public ResponseEntity<MerchantDTO> create(@RequestBody MerchantRequestDTO dto,
                                              HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.create(dto));
    }

    @ApiOperation(value = "Update merchant name", notes = "Method used for update merchant name for admin", nickname = "Bilol")
    @PutMapping("/name{merchantId}")
    public ResponseEntity<Boolean> updateName(@PathVariable("merchantId") String merchantId,
                                                  @RequestBody MerchantUpdateDetailDTO dto,
                                                  HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.updateName(merchantId, dto));
    }

    @ApiOperation(value = "Update merchant parsentage", notes = "Method used for update merchant parsentage for admin", nickname = "Bilol")
    @PutMapping("/parsentage{merchantId}")
    public ResponseEntity<Boolean> updateParsentage(@PathVariable("merchantId") String merchantId,
                                              @RequestBody MerchantUpdateDetailDTO dto,
                                              HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.updateParsentage(merchantId, dto));
    }

    @ApiOperation(value = "Update merchant status", notes = "Method used for update merchant status for admin", nickname = "Bilol")
    @PutMapping("/status{merchantId}")
    public ResponseEntity<Boolean> updateStatus(@PathVariable("merchantId") String merchantId,
                                                    @RequestParam MerchantStatus status,
                                                    HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.updateStatus(merchantId, status));
    }

    @ApiOperation(value = "Update merchant card", notes = "Method used for update merchant card for admin", nickname = "Bilol")
    @PutMapping("/card{merchantId}")
    public ResponseEntity<Boolean> updateCard(@PathVariable("merchantId") String merchantId,
                                                @RequestParam MerchantUpdateDetailDTO card,
                                                HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.updateCard(merchantId, card));
    }

    @ApiOperation(value = "Update merchant category", notes = "Method used for update merchant category for admin", nickname = "Bilol")
    @PutMapping("/category{merchantId}")
    public ResponseEntity<Boolean> updatedCategory(@PathVariable("merchantId") String merchantId,
                                                @RequestParam MerchantUpdateDetailDTO category,
                                                HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.updatedCategory(merchantId, category));
    }

    @ApiOperation(value = "Delete merchant", notes = "Method used for delete merchant for admin", nickname = "Bilol")
    @DeleteMapping("/{merchantId}")
    public ResponseEntity<Boolean> delete(@PathVariable("merchantId") String merchantId,
                                                HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.delete(merchantId));
    }

    @ApiOperation(value = "Get merchant list", notes = "Method used for get merchant list for admin", nickname = "Bilol")
    @GetMapping("")
    public ResponseEntity<PageImpl<MerchantDTO>> getList(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "5") int size,
                                            HttpServletRequest request){
        JwtUtil.getIdFromHeader(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(merchantService.getList(page, size));
    }






}
