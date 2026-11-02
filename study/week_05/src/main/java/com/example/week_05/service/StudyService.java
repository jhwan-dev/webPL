package com.example.week_05.service;

import com.example.week_05.domain.Study;
import com.example.week_05.dto.StudyForm;
import com.example.week_05.repository.StudyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // 이 클래스가 업무처리를 담당하는 spring의 객체임을 의미
public class StudyService {
    private final StudyRepository studyRepository;
    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }
//    생성자 주입은 클래스가 필요한 객체를 생성자의 매개변수로 전달 받는 방식,
//    Spring은 필요한 빈을 찾아 자동으로 전달한다. 이를 통해 객체 간 의존성을 관리하기 쉽고
//    final을 사용하면 생성 후 참조를 변경하지 못하도록 할 수 있다.
    //저장공간 리스트
    // 클래스명을 자료형으로
    /*
    public class Study {
    private Long id;
    private String name;
    private String topic;
    private Integer studyHours;
    }
     */
    private final List<Study> studies = new ArrayList<>();
    //public 반환형 save(매개변수)
    public void save(StudyForm studyForm){
        Study study = new Study(
                studyForm.getName(),
                studyForm.getTopic(),
                studyForm.getStudyHours());
        studyRepository.save(study);
//        save 두개가 다름 구분
    }
//     자료형: List<Study>
    public List<Study> findAll() {
        return studies;
    }

    public void save(String name, String topic, Integer studyHours) {
        Study study=new Study(
                name,
                topic,
                studyHours
        );
    }
}
