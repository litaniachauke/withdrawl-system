package com.enviro.assessment.grad001.withdrawlsystem.services.serviceImplemetation;

import com.enviro.assessment.grad001.withdrawlsystem.Repository.ProductRepository;
import com.enviro.assessment.grad001.withdrawlsystem.Repository.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Address;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Investor;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class InvestorServiceImplementationTest {

    @InjectMocks
    private InvestorServiceImplementation investorServiceImplementation;
    @Mock
    private WithdrawalNoticeRepository withdrawalNoticeRepository;
    @Mock
    private ProductRepository productRepository;
    private final InvestorDTO investorDTO = new Investor(UUID.randomUUID(),"firstName", "lastName",18, "email", "phone",
            new Address(UUID.randomUUID(),"street", "city", "province", "1901", "country"),new ArrayList<>()).toDTO();
    private final ProductDTO productDTO = new Product("name", "description","type",new Investor().fromDTO(investorDTO), 100).toDTO();
    private final WithdrawalNoticeDTO withdrawalNoticeDTO = new WithdrawalNotice(new Product().fromDTO(productDTO), 50).toDTO();

    @Test
    void makeWithdrawal() {
        when(productRepository.save(any())).thenReturn(new Product().fromDTO(productDTO));
        when(productRepository.findById(productDTO.id())).thenReturn(Optional.of(new Product().fromDTO(productDTO)));

        assertTrue(investorServiceImplementation.makeWithdrawal(productDTO.id(), 50));
    }
    @Test
    void makeWithdrawalFail() {
        when(productRepository.save(any())).thenReturn(new Product().fromDTO(productDTO));
        when(productRepository.findById(productDTO.id())).thenReturn(Optional.of(new Product().fromDTO(productDTO)));

        try {
            assert !investorServiceImplementation.makeWithdrawal(productDTO.id(), 100) : "Exception not thrown";
        } catch (RuntimeException e) {
            assertEquals("Not enough balance!!", e.getMessage());
        }
    }
}