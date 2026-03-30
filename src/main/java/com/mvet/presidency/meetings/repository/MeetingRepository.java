package com.mvet.presidency.meetings.repository.MeetingRepository;

import com.mvet.presidency.meetings.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
