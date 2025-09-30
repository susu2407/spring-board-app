package kr.co.sboard.repository;

import kr.co.sboard.entity.Terms;
import kr.co.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // 정의해야 함.
    // 사용자 정의 쿼리메서드
    public int countByUsid(String usid); // 메서드 이름은 우리 마음데로 짓는게 아니라, 규칙이 있다.
    public int countByNick(String nick); // 닉네임 중복 체크
    public int countByEmail(String email); // 이메일 중복 체크
    public int countByHp(String hp);

}