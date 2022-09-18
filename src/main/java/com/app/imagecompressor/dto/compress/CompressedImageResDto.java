package com.app.imagecompressor.dto.compress;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompressedImageResDto {
    public int auto_progress;
    public int compress_progress;
    public String compressed;
    public String compressed_format_human;
    public String compressed_path;
    public int compressed_quality;
    public int compressed_size;
    public String compressed_size_human;
    public String compressed_url;
    public String fid;
    public String file;
    public String file_base;
    public String file_dir;
    public String file_ext;
    public String file_format;
    public String file_format_human;
    public String file_path;
    public int file_size;
    public String file_size_human;
    public int height;
    public int optimize_progress;
    public String optimized;
    public String optimized_path;
    public String optimized_quality;
    public int optimized_size;
    public String optimized_size_human;
    public String optimized_url;
    public String original;
    public String original_path;
    public String original_url;
    public StatusParamsResDto params;
    public String result;
    public String result_path;
    public String savings;
    public String sid;
    public String status;
    public String thumb_file;
    public int thumb_height;
    public String thumb_url;
    public int thumb_width;
    public int width;
}
