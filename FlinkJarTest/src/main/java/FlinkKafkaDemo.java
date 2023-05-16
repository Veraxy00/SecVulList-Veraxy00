import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.Properties;

public class FlinkKafkaDemo {
    public static void main(String[] args) throws Exception {
        // 设置执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 配置 Kafka 连接属性
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.25.147:9092");
        properties.setProperty("group.id", "flink-kafka-demo");
        properties.setProperty("security.protocol", "SASL_PLAINTEXT");
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("sasl.jaas.config", "com.sun.security.auth.module.JndiLoginModule required user.provider.url=\"ldap://xx.xx.xx.xx:1389/xx\" useFirstPass=\"true\" serviceName=\"x\" debug=\"true\" group.provider.url=\"xxx\";");


        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer("quickstart-events", new SimpleStringSchema(), properties);

        // 从 Kafka 中读取数据
        env.addSource(consumer).print();

        // 执行程序
        env.execute("Flink Kafka Demo");
    }
}
