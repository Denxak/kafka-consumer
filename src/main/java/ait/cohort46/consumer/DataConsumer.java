package ait.cohort46.consumer;

import ait.cohort46.model.SensorData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.function.Consumer;

@Component
public class DataConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public Consumer<String> log() {
        return message -> {
            try {
                SensorData data = objectMapper.readValue(message, SensorData.class);
                long delay = System.currentTimeMillis() - data.getTimestamp();
                System.out.println("delay: " + delay + ", payload: " + data.getPulse() + ", id: " + data.getId());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        };
    }
}
