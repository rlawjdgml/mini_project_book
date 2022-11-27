package com.example.boot2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // @Getter + @Setter + @ToString + ...
public class PostUpdateDto {
    private String title;
    private String content;

}
