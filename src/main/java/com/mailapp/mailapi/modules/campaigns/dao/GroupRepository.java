package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.Group;
import com.mailapp.mailapi.modules.campaigns.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into ReceiverGroupLink (groupid, receiverId) values (:groupid, :reveiverid)", nativeQuery = true)
    void addLinkToPersons(
            @Param("groupid") Long id,
            @Param("reveiverid") Long status
    );
}
