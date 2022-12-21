package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ViewRepository extends JpaRepository<View, Long> {

    @Query("from View v join fetch v.parent p join fetch p.parent pp")
    List<View> findAllViews();
}
