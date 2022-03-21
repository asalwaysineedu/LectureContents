package com.example.demo.service.jpa.order58;

import com.example.demo.controller.jpa.order58.request.MemberRequest;
import com.example.demo.entity.jpa.VueJpaMemberAuth;
import com.example.demo.entity.jpa.VueJpaMemberWithAuth;
import com.example.demo.repository.jpa.order58.VueJpaMemberWithAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaMemberServiceImpl implements JpaMemberService {

    @Autowired
    private VueJpaMemberWithAuthRepository memberRepository;

    @Override
    public void register(MemberRequest memberRequest) {
        VueJpaMemberAuth authEntity = new VueJpaMemberAuth(memberRequest.getAuth());
        VueJpaMemberWithAuth memberEntity = new VueJpaMemberWithAuth(
                memberRequest.getId(), memberRequest.getPw());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }
}
