package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SentCampaignRepository extends JpaRepository<SentCampaign, UUID> {

    @Query("from SentCampaign sc join fetch sc.parent p join fetch sc.template t where p.id = :id and t.id = sc.template.id")
    List<SentCampaign> findAllSentCampaignsByParentId(UUID id);


    @Modifying
    @Transactional
    @Query(value = "insert into SentCampaigns (id, campaignId, templateId, receiversGroupId, startDate) " +
            "values (NEWID(), :campaignId, :templateId, :receiversGroupId,  GETDATE())", nativeQuery = true)
    void insert(
            @Param("campaignId") Long campaignId,
            @Param("templateId") Long templateId,
            @Param("receiversGroupId") Long receiversGroupId
    );

    Optional<SentCampaign> findById(UUID id);
}
