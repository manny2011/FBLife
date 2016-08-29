package com.group.yztcedu.fblife.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.group.yztcedu.fblife.R;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Polaris on 2016/8/5.
 */
public class QRUtils {
    /**
     * 生成二维码
     * @param context
     * @param content
     * @param width
     * @param imgImageView
     */
    public static void createQRCode(Context context,String content, int width, ImageView imgImageView) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            Map<EncodeHintType, Object> map = new HashMap<EncodeHintType, Object>();
            map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix matrix = writer.encode(content, BarcodeFormat.QR_CODE,
                    width, width, map);
            Bitmap bm = Bitmap.createBitmap(width, width, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < width; y++) {
                    if (matrix.get(x, y)) {
                        bm.setPixel(x, y, Color.BLACK);
                    } else {
                        bm.setPixel(x, y, Color.WHITE);
                    }
                }
            }
            Bitmap ic = BitmapFactory.decodeResource(context.getResources(),
                    R.mipmap.detail_person_icon);
            Rect s = new Rect(0, 0, ic.getWidth(), ic.getHeight());
            Rect dst = new Rect(width * 2 / 5, width * 2 / 5, width * 3 / 5,
                    width * 3 / 5);
            new Canvas(bm).drawBitmap(ic, s, dst, null);
            imgImageView.setImageBitmap(bm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getStringFromQRCode(Drawable drawable) {
        String httpString = null;

        Bitmap bmp = ImageUtils.drawableToBitmap(drawable);
        byte[] data = ImageUtils.getYUV420sp(bmp.getWidth(), bmp.getHeight(), bmp);
        // 处理
        try {
            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
//            hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
            PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(data,
                    bmp.getWidth(),
                    bmp.getHeight(),
                    0, 0,
                    bmp.getWidth(),
                    bmp.getHeight(),
                    false);
            BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
            QRCodeReader reader2= new QRCodeReader();
            Result result = reader2.decode(bitmap1, hints);

            httpString = result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bmp.recycle();
        bmp = null;

        return httpString;
    }


}
