package com.app.imagecompressor.dto.compress;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusParamsResDto {
    public int colors_default;
    public int colors_max;
    public int colors_min;
    public int quality;
    public int quality_default;
    public int quality_max;
    public int quality_min;
}
