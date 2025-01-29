package com.test.jooqtest.repo;

import com.test.jooqtest.generated.tables.Human;
import com.test.jooqtest.generated.tables.records.HumanRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class HumanTableRepository {

    private final DSLContext dslContext;

    public void saveHumanList(List<HumanRecord> humanList) {
//        dslContext.batch(
//                humanList.stream()
//                .map(human ->
//                    dslContext.insertInto(Human.HUMAN,
//                                    Human.HUMAN.NAME,
//                                    Human.HUMAN.HEIGHT,
//                                    Human.HUMAN.WEIGHT,
//                                    Human.HUMAN.DESCRIPTION,
//                                    Human.HUMAN.NICKNAME,
//                                    Human.HUMAN.SONG,
//                                    Human.HUMAN.INSTRUMENT
//                            )
//                            .values(human.getName(),
//                                    human.getHeight(),
//                                    human.getWeight(),
//                                    human.getDescription(),
//                                    human.getNickname(),
//                                    human.getSong(),
//                                    human.getInstrument()
//                            )
//                ).collect(Collectors.toList())
//        ).execute();

//        dslContext.batchInsert(humanList).execute();

        // batchInsert시 개별트랜잭션이 돌아 느리게 Insert 되므로 하나로 묶어주는 작업이 필요
        dslContext.transaction(configuration -> {
            configuration.dsl()
                    .batchInsert(humanList)
                    .execute();
        });

    }
}
