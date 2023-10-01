package com.uniteam.flashmemorizer.entity.key;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

@Data
@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
public class UserCardId implements Serializable{
    private Long cardId;
    private Long userId;
}