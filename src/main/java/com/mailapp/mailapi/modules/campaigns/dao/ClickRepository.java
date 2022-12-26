package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ClickRepository extends JpaRepository<Click, Long> {

    @Query("from Click c join fetch c.parent p join fetch p.parent pp join fetch p.group g where p.id = :id")
    List<Click> findAllByCampaignId(@Param("id") UUID id);
}
