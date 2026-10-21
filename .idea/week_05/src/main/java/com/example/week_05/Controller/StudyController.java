package com.example.week_05.Controller;

import com.example.week_05.dto.StudyForm;
import com.example.week_05.service.StudyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//에러찾기, 어노테이션, 자료형 등 흐름 위주로 공부

@Controller
@RequestMapping("/study")
// 이 controller에서 사용하는 공통 요청 주소를 /study
public class StudyController {
    private final StudyService studyService;
    public StudyController(StudyService studyService) {
        this.studyService=studyService;
    }
//    흐름 문제 나올 수 있음
    /*생산자 주입: 의존성을 고정하기 위해 사용
               Spring 컨테이너가 관리하는 의존 객체를 통해서 전달하는 방식
     */
    // 스터디 신청의 저장과 조회를 담당하는 service
    @GetMapping("/new")
    public String showStudyForm(Model model) {
        model.addAttribute("studyForm", new StudyForm());
        return "study-form";
    }

    @PostMapping
    public String applyStudy(
            @Valid @ModelAttribute("studyForm")
            StudyForm studyForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "study-form";
        }
        studyService.save(studyForm);
        return"redirect:/study";
    }
    @GetMapping
//    model 생성자는 스프링이 해주기 때문에 new가 필요없음
    public String showStudyList(Model model) {
        model.addAttribute("studies", studyService.findAll());
        return "study-list";
    }
}
//        @ModelAttribute의 역할
//        1. 폼에서 전달된 name, topic, studyHours와 값을
//        StudyForm 개체의 같은 이름을 가진 프로퍼티에 자동으로 바인딩
//        2. 만들어진 StudyForm 객체를 studyForm이라는 이름으로 자동으로 추가
//        앞의 StudyForm은 자료형 뒤의 studyForm은 실제 자바 변수
//        RequestParam은 입력값을 하나씩 받음 -> 입력값이 적으면 유용 but 매개변수 늘어나면 불편
//        주석 내용에서 짚을 것
//모델 이름은 변수명이 아니라 어노테이션 값에서 정해집니다. "뒤의 studyForm은 실제 자바 변수"라는 설명 자체는 맞지만, 2번 항목과 같이 읽으면 변수명이 모델 이름이 되는 것처럼 오해할 수 있어요. 모델에 들어가는 키는 @ModelAttribute("studyForm")의 문자열입니다. 값을 생략하면 클래스명의 첫 글자를 소문자로 바꾼 studyForm이 기본 이름이 되고요. 그래서 변수명을 form으로 바꿔도 템플릿에서는 여전히 ${studyForm}으로 접근합니다. 주석에 이 구분을 적어 두면 시험 대비로 더 정확할 것 같습니다.
//"자동으로 추가"는 “Model에 자동으로 추가”라고 대상을 명시하면 더 명확하고, "개체"는 "객체"의 오타로 보입니다.
//Valid: StudyFrom 객체의 필드위에 있는 검증 조건을 검사하도록 요청 하는 것.
//BindingResult는 검증 대상 모델 개체 바로 뒤에 두어야 해당 객체의
//바인딩, 검증오류를 controller에서 처리할 수 있다

