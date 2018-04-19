package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.alibaba.fastjson.util.IOUtils;

/**
 * Created by ym on 2018/4/19 0019.
 */
public class FileUtils {

    public static void main(String[] args) throws Exception {
        File file1 = new File("E:\\api报文.png");
        File file2 = new File("E:\\api报文-copy.png");
        //System.out.println(forChannel(file1,file2));
    }

    public static long forChannel(File f1, File f2) throws Exception{
        long time=System.currentTimeMillis();
        int length=2097152;
        FileInputStream in=new FileInputStream(f1);
        FileOutputStream out=new FileOutputStream(f2);
        FileChannel inC=in.getChannel();
        FileChannel outC=out.getChannel();
        ByteBuffer b=null;
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return System.currentTimeMillis()-time;
            }
            if((inC.size()-inC.position())<length){
                length=(int)(inC.size()-inC.position());
            }else{
                length=2097152;
            }
            b=ByteBuffer.allocateDirect(length);
            inC.read(b);
            b.flip();
            outC.write(b);
            outC.force(false);
        }
    }
    private static void nioTransferCopy(File source, File target) {
        FileChannel in = null;
        FileChannel out = null;
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            inStream = new FileInputStream(source);
            outStream = new FileOutputStream(target);
            in = inStream.getChannel();
            out = outStream.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(inStream);
            IOUtils.close(in);
            IOUtils.close(outStream);
            IOUtils.close(out);
        }
    }
}
