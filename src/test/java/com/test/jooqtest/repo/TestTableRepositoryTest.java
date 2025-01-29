package com.test.jooqtest.repo;

import com.test.jooqtest.generated.tables.records.TestTableRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class TestTableRepositoryTest {

    @Autowired
    private TestTableRepository testTableRepository;

    @Test
    void saveTestTable() {
        testTableRepository.saveTestTable("TESTNAME", 12123, "ASDASDASDAS");
    }

    @Test
    void findAllData() {
        List<TestTableRecord> testTables = testTableRepository.findAllData();
        assertThat(testTables).isNotEmpty();
    }

    @Test
    void testBulkInsert() {
        
    }
}