package ait.cohort46.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorData {
    private int id;
    private long timestamp;
    private int pulse;
}
