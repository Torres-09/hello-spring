package hello.hellospring.service;

import hello.hellospring.controller.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

// ctrl + shift + t - > test 자동생성
//@Service    //spring이 컨테이너에 등록한다.
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        // 같은 이름이 있는 중복 회원은 안된다.

        validateDuplicateMember(member);    // 중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조최
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // Id 찾기
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
