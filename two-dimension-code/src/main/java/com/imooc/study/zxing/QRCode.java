package com.imooc.study.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author Created by Wesley on 2016/7/30.
 */
public class QRCode {
    /** 默认宽度*/
    private static final int WIDTH = 300;
    /** 默认高度*/
    private static final int HEIGHT = 300;

    private final Writer writer = new MultiFormatWriter();

    private final BitMatrix bitMatrix;

    private final HashMap<EncodeHintType, Object> hints;

    public QRCode(String content) throws WriterException {
        this(WIDTH, HEIGHT, content, defaultHints());
    }

    public QRCode(int width, int height, String content, HashMap<EncodeHintType, Object> hints) throws WriterException {
        this.hints = hints;
        this.bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
    }

    private static HashMap<EncodeHintType, Object> defaultHints(){
        HashMap<EncodeHintType, Object> result = new HashMap<>();
        result.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        result.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        return result;
    }


    private QRCode writeToPath(String format, Path path) throws WriterException, IOException {
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        return this;
    }

    public static void main(String[] args) throws WriterException, IOException {
        Path path = new File("D:\\code.png").toPath();
        new QRCode("www.hah.com").writeToPath("png", path);
    }

//    public static QRCode getInstance(String content) throws WriterException {
//        return new QRCode(content);
//    }
//
//    public static QRCode getInstance(int width, int height, String content) throws WriterException {
//        return new QRCode(width, height, content);
//    }
}
