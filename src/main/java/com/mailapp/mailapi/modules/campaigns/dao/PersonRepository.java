package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from Receivers r" +
            " join ReceiverGroupLink rg on r.id = rg.receiverId" +
            " where rg.groupId = :groupId ", nativeQuery = true)
    List<Person> findByGroupId(
            @Param("groupId") Long groupId
    );
}
