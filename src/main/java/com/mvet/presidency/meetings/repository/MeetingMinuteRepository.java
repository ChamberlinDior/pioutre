package com.mvet.presidency.meetings.repository.MeetingMinuteRepository;

import com.mvet.presidency.meetings.entity.MeetingMinute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingMinuteRepository extends JpaRepository<MeetingMinute, Long> {
}
