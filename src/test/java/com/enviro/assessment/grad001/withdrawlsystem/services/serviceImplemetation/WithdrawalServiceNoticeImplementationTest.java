package com.enviro.assessment.grad001.withdrawlsystem.services.serviceImplemetation;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class WithdrawalServiceNoticeImplementationTest {
    @InjectMocks
    private WithdrawalServiceNoticeImplementation withdrawalServiceNoticeImplementation;
    @Mock
    private WithdrawalNoticeRepository withdrawalNoticeRepository;
    private final InvestorDTO investorDTO = new Investor(UUID.randomUUID(),"firstName", "lastName",18, "email", "phone",
            new Address(UUID.randomUUID(),"street", "city", "province", "1901", "country"),new ArrayList<>()).toDTO();
    private final ProductDTO productDTO = new Product("name", "description","type",new Investor().fromDTO(investorDTO), 100).toDTO();
    private final WithdrawalNoticeDTO withdrawalNoticeDTO = new WithdrawalNotice(new Product().fromDTO(productDTO), 50).toDTO();
    @Test
    void createWithdrawalNotice() {
        when(withdrawalNoticeRepository.save(any())).thenReturn(new WithdrawalNotice().fromDTO(withdrawalNoticeDTO));
        assertEquals(withdrawalNoticeDTO.toString(),withdrawalServiceNoticeImplementation.createWithdrawalNotice(withdrawalNoticeDTO).toString());
    }

    @Test
    void getWithdrawalNoticeByProduct() throws IOException {
        List<WithdrawalNotice> withdrawalNotices = new ArrayList<>();
        withdrawalNotices.add(new WithdrawalNotice().fromDTO(withdrawalNoticeDTO));
        when(withdrawalNoticeRepository.findByProduct(any())).thenReturn(withdrawalNotices);
        assertEquals(1, withdrawalServiceNoticeImplementation.getWithdrawalNoticeByProduct(new Product().fromDTO(productDTO)).size());
    }
}