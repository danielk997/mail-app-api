package com.mailapp.mailapi.modules.configuration.dao;

import com.mailapp.mailapi.modules.configuration.model.SmtpConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface SmtpConfigurationRepository extends JpaRepository<SmtpConfiguration, UUID> {

    SmtpConfiguration getSmtpConfigurationByActive(@NotNull Boolean active);
}
