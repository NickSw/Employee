package com.server.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Вспомогательный класс для загрузки файла на сетвер
 */
public class FileBean {

    private CommonsMultipartFile fileData;

    public CommonsMultipartFile getFileData()
    {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData)
    {
        this.fileData = fileData;
    }
}