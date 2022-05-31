package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES (#{fileName}, #{contenttype}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addFile(File file);

    @Select("SELECT * FROM FILES")
    List<File> getAllFiles();

    @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
    File getFile(String  fileName);
    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    List<File> getFileByUserId();

    @Delete("DELETE FROM FILES WHERE fileid = #{fileId}")
    void deleteFileId(int fileId);


}
