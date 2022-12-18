package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SentCampaignRepository extends JpaRepository<SentCampaign, UUID> {

    @Query("from SentCampaign sc join fetch sc.parent p join fetch sc.template t where p.id = :id and t.id = sc.template.id")
    List<SentCampaign> findAllSentCampaignsByParentId(UUID id);

    Optional<SentCampaign> findById(UUID id);
}
