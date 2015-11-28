package com.cust.qmsys.domain.question;

import java.util.Date;

import com.cust.qmsys.domain.Subject;
import com.cust.qmsys.domain.User;

public class Judge {
    /**
     * ≈–∂œÃ‚
     */
    private Long qid;
    private Integer type;
    private String body;
    private Integer answer;
    private Double score;
    private Integer level;
    private Integer chapter;
    private String image;
    private Date create_time;
    private User createuser;
    private Subject subject;
    private Integer usetime;

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateTime() {
        return create_time;
    }

    public void setCreateTime(Date create_time) {
        this.create_time = create_time;
    }

    public User getCreateUser() {
        return createuser;
    }

    public void setCreateUser(User createuser) {
        this.createuser = createuser;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getUsetime() {
        return usetime;
    }

    public void setUsetime(Integer usetime) {
        this.usetime = usetime;
    }
}
