package hello.hellospring.service;

import hello.hellospring.controller.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


// commit을 해야지 반영이 된다. Transactional 어노테이션을 붙이면 test 이후에 rollback이 자동으로 되어서 DB에 반영이 되지 않는다.
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // test 코드 같은 경우에는 name 한글로 해도 무방하다. ( 영어권 사람들과 일 하는 게 아니라면 )
    // test 코드는 실제 코드에 포함되지 않는다.

    @Autowired
    MemberService memberService;


    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId). get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 중복 회원 검증
    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("srping");


        Member member2 = new Member();
        member2.setName("srping");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}