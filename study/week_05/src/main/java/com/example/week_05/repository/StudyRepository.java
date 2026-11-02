package com.example.week_05.repository;

import com.example.week_05.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

//인터페이스: 설정되어있는 기능을 사용할 수 있다는 규칙
//JpaRepository<Study, Long>: Study-관리할 엔터티 클래스
//Long: 해당 엔터티의 기본키(PK)의 자료형
//JpaRepository를 상속받아 Spring DATA JPA가 CRUD(생성조회업데이트삭제)등의
//기본 DB작업을 구현하지 않아도 사용
public interface StudyRepository extends JpaRepository<Study, Long> {
//    save(): C 저장, 변경
//    findAll(): 전체 조회
//    findById(): 특정 id 조회
//    deleteById(): 특정 id 삭제
}
