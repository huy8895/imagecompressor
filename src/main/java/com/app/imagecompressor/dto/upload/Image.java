package com.app.imagecompressor.dto.upload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    public String fid;
    public String file;
    public String file_base;
    public String file_dir;
    public String file_ext;
    public String file_format;
    public String file_path;
    public int file_size;
    public String file_size_human;
    public String sid;
}
