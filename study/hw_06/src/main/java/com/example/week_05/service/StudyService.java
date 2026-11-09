package com.example.week_05.service;

import com.example.week_05.domain.Study;
import com.example.week_05.repository.StudyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service // 업무 처리를 담당하는 Spring 객체
public class StudyService {

    private final StudyRepository studyRepository;

    // 생성자 주입: 필요한 객체를 생성자 매개변수로 전달받음.
    // Spring이 StudyRepository 구현체를 찾아 자동으로 넣어 준다.
    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    // Controller가 호출하는 save
    public void save(String name, String topic, Integer studyHours) {
        Study study = new Study(name, topic, studyHours);
        studyRepository.save(study);     // ← 추가: 실제 DB 저장 (JpaRepository의 save)
    }

    public List<Study> findAll() {
        return studyRepository.findAll(); // ← 변경: ArrayList가 아니라 DB에서 조회
    }

    public Study findById(Long id)  {
        return studyRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException(
                                "해당 스터디 신청을 찾을 수 없습니다."
                        ));
    }

    //@Transactional: 트랜잭션 시작,커밋(작업 결과를 db에 최종 확정한다),롤백(작업을 취소하고 트랜잭션 시작 전으로 돌아간다) 관리
//    트랜잭션: DB에서 여러 작업들을 하나의 작업의 단위로 묶어서 처리하는 과정
//    실제 호출순서: StudySerivce.findById()호출 -> StudyRepository.save()
//    -> Hibernate가 SQL을 실행하고 저장한다
//    StudyService.findByID()를 거치지 않고 repository 작업 호출
//    save() 호출 불필요, -> 트랜잭션 커밋 과정에서 Hibernate 변경 감지
//    10주치 참고 설명용 코드는 참고만 공부 x
    @Transactional
    public void update(Long id, String name, String topic, Integer studyHours) {
        Study study=findById(id);
        study.setName(name);
        study.setTopic(topic);
        study.setStudyHours(studyHours);
    }
    @Transactional
    public void delete(Long id) {
        findById(id);
        studyRepository.deleteById(id);
    }
}