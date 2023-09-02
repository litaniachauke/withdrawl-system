package com.enviro.assessment.grad001.withdrawlsystem.Repository;

import com.enviro.assessment.grad001.withdrawlsystem.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvestorRepository extends JpaRepository<Investor, UUID> {

}
