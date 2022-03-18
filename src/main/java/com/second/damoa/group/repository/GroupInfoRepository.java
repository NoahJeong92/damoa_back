package com.second.damoa.group.repository;

import com.second.damoa.group.model.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
    // 그룹에 가입한 회원 조회
    @Modifying
    @Query(value = "select user.name, user.id from GroupInfo join User on groupinfo.group_no = user.group_no where groupinfo.group_no = :id", nativeQuery = true)
    List<JoinUserInterface> joinUser(@Param("id") Long id);

    // 그룹 가입
    @Modifying
    @Query(value = "update User set user.group_no = :id where name = :name", nativeQuery = true)
    int joinGroup(@Param("id") Long id, @Param("name") String name);

    // 그룹 이미지 변경
    @Modifying
    @Query(value = "update GroupInfo set groupinfo.group_img = :groupImg where groupinfo.group_no = :id", nativeQuery = true)
    int imgUpdateQuery(@Param("id") Long id, @Param("groupImg") String groupImg);

//    // 그룹 title 검색
//    List<GroupInfo> findByTitleContaining(String keyword);

//    // 조회수 카운트 쿼리
//    @Modifying
//    @Query("update GroupInfo p set p.count = p.count + 1 where p.id = :id")
//    int updateCount(Long id);

}
