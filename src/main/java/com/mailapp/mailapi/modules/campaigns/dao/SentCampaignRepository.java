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

    @Query("from SentCampaign sc" +
            " join fetch sc.parent p" +
            " join fetch sc.template t " +
            " join fetch sc.group g" +
            " where p.id = :id")
    List<SentCampaign> findAllSentCampaignsByParentId(Long id);


    @Modifying
    @Transactional
    @Query(value = "insert into SentCampaigns (id, campaignId, templateId, sender, title, receiversGroupId, startDate) " +
            "values (NEWID(), :campaignId, :templateId, :sender, :title, :receiversGroupId,  GETDATE())", nativeQuery = true)
    void insert(
            @Param("campaignId") Long campaignId,
            @Param("templateId") Long templateId,
            @Param("sender") String sender,
            @Param("title") String title,
            @Param("receiversGroupId") Long receiversGroupId
    );

    @Modifying
    @Transactional
    @Query(value = "update SentCampaigns set status = :status where id like :id", nativeQuery = true)
    void updateStatus(
            @Param("id") String id,
            @Param("status") String status
    );

    @Query("from SentCampaign sc" +
            " join fetch sc.parent p" +
            " join fetch sc.template t " +
            " join fetch sc.group g")
    List<SentCampaign> findAll();

    Optional<SentCampaign> findById(UUID id);
}
