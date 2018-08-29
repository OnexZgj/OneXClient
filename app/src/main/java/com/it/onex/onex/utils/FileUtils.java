package com.it.onex.onex.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Linsa on 2018/8/29:19:02.
 * des:操作文件
 */

public class FileUtils {

    /**
     * 文件复制
     * @param source
     * @param target
     */
    public static void copy(File source ,File target)  {
        FileInputStream fis=null;
        FileOutputStream fos=null;


        try {
            fis=new FileInputStream(source);

            fos=new FileOutputStream(target);

            byte[] buffer =new byte[1024];

            while (fis.read(buffer)>0){
                fos.write(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
