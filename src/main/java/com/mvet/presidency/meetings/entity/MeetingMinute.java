package com.mvet.presidency.meetings.entity;

import com.mvet.presidency.common.entity.AuditableEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "meeting_minutes")
public class MeetingMinute extends AuditableEntity {

    @ManyToOne(optional = false) @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    @Column(length = 4000)
    private String summary;

    public Meeting getMeeting() { return meeting; }
    public String getSummary() { return summary; }

    public void setMeeting(Meeting meeting) { this.meeting = meeting; }
    public void setSummary(String summary) { this.summary = summary; }
}
