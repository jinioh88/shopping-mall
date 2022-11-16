package com.shop;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Auditing 테스트")
    @WithMockUser(username = "gildong", roles = "USER")
    void auditingTest() {
        Member member = new Member();
        memberRepository.save(member);

        em.flush();
        em.clear();

        Member founded = memberRepository.findById(member.getId()).orElseThrow(EntityNotFoundException::new);
        System.out.println(founded.getCreatedBy());
        System.out.println(founded.getRegTime());
    }
}
