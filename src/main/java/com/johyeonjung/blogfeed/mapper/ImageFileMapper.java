package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.ImageFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageFileMapper {
    int insertToMany(List<ImageFile> files);
}
