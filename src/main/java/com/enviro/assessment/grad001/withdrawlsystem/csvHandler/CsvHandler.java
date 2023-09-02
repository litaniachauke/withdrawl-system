package com.enviro.assessment.grad001.withdrawlsystem.csvHandler;

import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Service
public class CsvHandler {
    public boolean exportCsv(List<WithdrawalNotice> withdrawalNotices) throws IOException {
        if(withdrawalNotices != null) {
            String path = "src/resources/csv/withdrawalNotice.csv";
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(withdrawalNotices.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        }else {
            throw new RuntimeException("Withdrawal Notices are empty!");
        }
    }
}
