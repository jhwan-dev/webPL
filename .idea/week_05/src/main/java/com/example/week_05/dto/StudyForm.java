package com.example.week_05.dto;

import jakarta.validation.constraints.*;

public class StudyForm {
    @NotBlank(message = "이름을 입력하세요")//공백구분
    @Size(max=20, message = "이름은 20자 이내이어야 합니다.")
    private String name;
    @NotBlank(message = "학습주제를 입력하세요")
    private String topic;
    @NotNull(message = "주당 학습시간을 입력하세요")
    @Min(value = 1, message = "학습시간은 1시간 이상 이어야 합니다.")
    @Max(value = 40, message = "학습시간은 40시간 이내 이어야 합니다")
    private Integer studyHours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }
}
