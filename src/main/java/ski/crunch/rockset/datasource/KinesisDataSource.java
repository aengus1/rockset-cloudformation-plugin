package ski.crunch.rockset.datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ski.crunch.utils.Helpers.checkRequiredParameters;

public class KinesisDataSource  implements  DataSource{

    private String  kinesisStreamName;
    private String kinesisAwsRegion;

    public String getKinesisStreamName() {
        return kinesisStreamName;
    }

    public String getKinesisAwsRegion() {
        return kinesisAwsRegion;
    }

    @Override
    public void parse(Map<String, Object> input ) {
        List<String> requiredParams = Stream.of(
                "KinesisStreamName",
                "KinesisAwsRegion"
        ).collect(Collectors.toList());
        checkRequiredParameters(input, requiredParams);
        kinesisStreamName = (String) input.get("KinesisStreamName");
        kinesisAwsRegion = (String) input.get("KinesisAwsRegion");
    }

    @Override
    public JsonNode toJson(ObjectMapper objectMapper) {
        ObjectNode properties = objectMapper.createObjectNode();
        properties.put("stream_name", kinesisStreamName);
        properties.put("aws_region", kinesisAwsRegion);
        return properties;
    }

    @Override
    public RocksetIntegrationType getIntegrationType() {
        return RocksetIntegrationType.kinesis;
    }
}
