package com.app.imagecompressor.dto.download;

import com.app.imagecompressor.dto.upload.Image;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadResDto {
    public String con;
    public Image image;
    public String jsonrpc;
    public Object result;
}
