package com.test.jooqtest.repo;

import com.test.jooqtest.generated.tables.TestTable;
import com.test.jooqtest.generated.tables.records.TestTableRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestTableRepository {

    private final DSLContext dslContext;

    public void saveTestTable(String name, Integer age, String address) {
        dslContext.insertInto(TestTable.TEST_TABLE)
                .columns(TestTable.TEST_TABLE.NAME, TestTable.TEST_TABLE.AGE, TestTable.TEST_TABLE.ADDRESS)
                .values(name, age, address)
                .execute();
    }

    public List<TestTableRecord> findAllData() {
        return dslContext.selectFrom(TestTable.TEST_TABLE).fetchInto(TestTableRecord.class);
    }

}
