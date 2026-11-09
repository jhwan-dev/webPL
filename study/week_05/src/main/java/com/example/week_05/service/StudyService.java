package com.example.week_05.service;

import com.example.week_05.domain.Study;
import com.example.week_05.repository.StudyRepository;
import org.springframework.stereotype.Service;

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
    public Study update(Long id, String name, String topic, Integer studyHours) {
        Study study=findById(id);
        study.update(name, topic, studyHours);
        return studyRepository.save(study);
    }
}