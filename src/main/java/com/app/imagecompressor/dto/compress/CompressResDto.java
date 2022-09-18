package com.app.imagecompressor.dto.compress;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompressResDto {
    public String contentType;
    public byte[] imageData;
}
