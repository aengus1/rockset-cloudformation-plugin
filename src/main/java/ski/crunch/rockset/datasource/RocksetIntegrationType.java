package ski.crunch.rockset.datasource;

public enum RocksetIntegrationType {
    dynamodb("DynamoDbDataSource"),
    s3("S3DataSource"),
    kinesis("KinesisDataSource");


    private String dataSourceName;

    public String getDataSourceName(){
        return this.dataSourceName;
    }

    RocksetIntegrationType(String dataSourceName){
        this.dataSourceName = dataSourceName;
    }
}
