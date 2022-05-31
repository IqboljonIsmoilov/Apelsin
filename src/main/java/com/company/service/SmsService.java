package com.company.service;

import com.company.entity.SmsEntity;
import com.company.repository.SmsRepository;
import com.company.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Autowired
    private SmsRepository smsRepository;

    public void create(String phone) {
        SmsEntity sms = new SmsEntity();
        String code = RandomUtil.getRandomSmsCode();
        sms.setContent(code);
        sms.setPhone(phone);

        String message = "Assalomu alaykum.\n Bu Mandarin uchun tastiqlash kodi: " + code;

        smsRepository.save(sms);
        this.sendSms(phone, message);
    }

    private void sendSms(String phone, String message) {

    }
}