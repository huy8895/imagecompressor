package com.app.imagecompressor.dto.upload;

import lombok.*;

import java.awt.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadResDto {
    public String id;
    public Image image;
    public String jsonrpc;
    public Object result;
}
