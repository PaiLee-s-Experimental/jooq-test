package com.test.jooqtest.repo;

import com.test.jooqtest.generated.tables.Human;
import com.test.jooqtest.generated.tables.records.HumanRecord;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HumanTableRepositoryTest {

    @Autowired
    private HumanTableRepository humanTableRepository;

    @Test
    void saveHumanList() {

        List<HumanRecord> humanRecordList = new ArrayList<>();
        int j=0;

        for (int i=0; i<=10000000; i++, j++) {
            humanRecordList.add(
                    new HumanRecord(
                            null,
                            getRandomString(),
                            getRandomInteger(),
                            getRandomInteger(),
                            getRandomString(),
                            getRandomString(),
                            getRandomString(),
                            getRandomString()
                    )
            );

            if (j % 5000 == 0 && j !=0) {
                humanTableRepository.saveHumanList(humanRecordList);
                humanRecordList.clear();
                System.out.println("DB INSERT");
            }
        }
    }


    private String getRandomString() {
        return RandomStringUtils.randomAlphabetic(45);
    }

    private Integer getRandomInteger() {
        return new SecureRandom().nextInt(20001) - 10000;
    }
}