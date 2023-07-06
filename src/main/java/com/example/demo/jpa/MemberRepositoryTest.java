package com.example.demo.jpa;

import com.example.demo.svc.controller.svcController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class MemberRepositoryTest {
    private static final Logger logger = LogManager.getLogger(svcController.class);

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception{
        Member member = new Member();
        member.setUsername("memberA");

        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        logger.info(findMember.getId());


    }
}
