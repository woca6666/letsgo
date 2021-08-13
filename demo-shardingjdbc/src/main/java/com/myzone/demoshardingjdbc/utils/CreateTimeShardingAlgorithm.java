package com.myzone.demoshardingjdbc.utils;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class CreateTimeShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        String[] split = preciseShardingValue.getValue().toString().split("-");
        return logicTableName + "_" + split[0]+split[1]+split[2];
    }
}
