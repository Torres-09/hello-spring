package hello.hellospring.repository;

import hello.hellospring.controller.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, null);
        // 실패할 경우, 기댓값과 실제값을 출력해준다.

        assertThat(member).isEqualTo(result);
        // Assertions를 import하면 함수명만 바로 사용가능


    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("srping1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("srping2");
        repository.save(member2);

        Member result = repository.findByName("srping1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
