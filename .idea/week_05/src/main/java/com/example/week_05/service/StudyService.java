package com.example.week_05.service;

import com.example.week_05.domain.Study;
import com.example.week_05.dto.StudyForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // 이 클래스가 업무처리를 담당하는 spring의 객체임을 의미
public class StudyService {
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
    private Long sequence = 1L;
    //public 반환형 save(매개변수)
    public void save(StudyForm studyForm){
        Study study = new Study(sequence++,
                studyForm.getName(),
                studyForm.getTopic(),
                studyForm.getStudyHours());
        studies.add(study);
    }
//     자료형: List<Study>
    public List<Study> findAll() {
        return studies;
    }
}
