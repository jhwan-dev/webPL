package com.example.week_05.domain;

public class Study {
    private Long id;
    private String name;
    private String topic;
    private Integer studyHours;

    public Study(Long id, String name, String topic, Integer studyHours) {
        this.id = id;
        this.name = name;
        this.topic = topic;
        this.studyHours = studyHours;
    }

    public Long getId() {
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
}
