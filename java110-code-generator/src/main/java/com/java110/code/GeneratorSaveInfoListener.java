package com.java110.code;

import java.io.*;
import java.util.Date;

public class GeneratorSaveInfoListener extends BaseGenerator {





    /**
     * 生成代码
     * @param data
     */
    public void generator(Data data){
        StringBuffer sb = readFile(this.getClass().getResource("/template/SaveListener.txt").getFile());
        String fileContext = sb.toString();
        fileContext = fileContext.replace("store",toLowerCaseFirstOne(data.getName()))
                .replace("Store",toUpperCaseFirstOne(data.getName()))
                .replace("商户",data.getDesc())
                .replace("BUSINESS_TYPE_SAVE_STORE_INFO",data.getNewBusinessTypeCd());
        System.out.println(this.getClass().getResource("/listener").getPath());
        String writePath = this.getClass().getResource("/listener").getPath()+"/Save"+toUpperCaseFirstOne(data.getName())+"InfoListener.java";
        writeFile(writePath,
                fileContext);
    }
}