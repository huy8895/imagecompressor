package com.app.imagecompressor.dto.compress;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompressStatusResDto {
    public String file_format;
    public String status;
}
