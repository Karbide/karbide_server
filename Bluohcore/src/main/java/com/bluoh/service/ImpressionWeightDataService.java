package com.bluoh.service;

import com.bluoh.model.ImpressionWeightData;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ImpressionWeightDataService {

    ImpressionWeightData create(ImpressionWeightData impressionWeightData);

    ImpressionWeightData delete(String id);

    List<ImpressionWeightData> findAll();

    ImpressionWeightData update(ImpressionWeightData impressionWeightData);


}
