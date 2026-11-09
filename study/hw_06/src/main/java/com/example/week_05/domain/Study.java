package com.example.week_05.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Entity가 붙으면 Study는 단순한 자바객체가 아니라 JAP가 관리하는 Entity가 된다.
//Entity, DB의 테이블과 매핑된 객체
//@GeneratedValue: 기본 키 값을 자동으로 생성하도록 지정
//(strategy = GenerationType.IDENTITY)
//IDENTITY: DB의 자동증가 기능을 이용해서 id를 생성하는 방식
@Entity
public class Study {
    @Id //기본키. P.K로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String topic;
    private Integer studyHours;
//    JPA기본 생성자 추가
//    JPA 접근제한자: protected/public
//    일반 코드가 접근할 필요가 없기때문에 protected 사용
    protected Study(){

    }
    public Study( String name, String topic, Integer studyHours) {

        this.name = name;
        this.topic = topic;
        this.studyHours = studyHours;
    }

    public Long getId(){
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public Integer getStudyHours() {
        return studyHours;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }
    public void update(String name, String topic, Integer studyHours) {
        this.name=name;
        this.topic=topic;
        this.studyHours=studyHours;
    }
}
