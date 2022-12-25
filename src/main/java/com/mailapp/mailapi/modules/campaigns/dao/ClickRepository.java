package com.mailapp.mailapi.modules.campaigns.dao;

import com.mailapp.mailapi.modules.campaigns.model.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {

}
