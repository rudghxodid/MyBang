package com.mybang.khweb.repository;

import com.mybang.khweb.entity.RoomMateComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomMateCommentRepository extends JpaRepository<RoomMateComment, Long> {
    List<RoomMateComment> findByMember_MemberNo(Long memberNo);
}
