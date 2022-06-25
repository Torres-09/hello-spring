package hello.hellospring.repository;

import hello.hellospring.controller.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    // Optional null 예외처리하기 위한 JAVA8의 기능이다.
}
