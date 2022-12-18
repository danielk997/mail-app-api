package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {
}
