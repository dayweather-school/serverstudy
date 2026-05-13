package com.example.exampleclass1.ttt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity // 이 클래스는 JPA 엔티티이다를 선언함. spring, JPA가 자동으로 DB 테이블과 연결해줌.
@Getter // 모든 필드에 getter 자동생성. 없으면 user.getUsername();을 적어야 함.
@NoArgsConstructor // 기본 생성자 생성. JPA는 기본 생성자고 무조건 필요함.
@SuperBuilder // 상속까지 포함해 Builder 패턴 사용 가능하게 함.
@Table(name = "users") // 매핑할 테이블 이름 지정. 여기선 users 테이블 사용하겠다고 선언함.
public class User // Entity, Table, public class User 이 클래스는 DB테이블과 1:1로 연결. 객체와 DB 레코드 자동 변환(ORM)(뭔 소린지..)
{

    @Id // 기본 키(?)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생 IDENTITY : DB가 자동으로 값 생. 1, 2, 3, 4, .....
    private Long id; // 아이디

    private String username; // 사용자 이름

    private String password; // 비번
}