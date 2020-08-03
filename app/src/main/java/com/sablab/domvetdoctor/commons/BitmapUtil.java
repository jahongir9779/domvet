package com.sablab.domvetdoctor.commons;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;


public final class BitmapUtil {


    final protected static char[] hexArray = "0123456789abcdef".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String calcSHA(byte b[]) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(b);
        return bytesToHex(md.digest());
    }

    public static String extractStackTrace(Throwable ex) {
        StringWriter result = new StringWriter();
        PrintWriter writer = new PrintWriter(result);
        ex.printStackTrace(writer);
        writer.close();
        return result.toString();
    }
    //----------------------------------------------------------------------------------------------

    public static Bitmap resizeByMaximum(Bitmap bitmap, int size) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) return resizeByWidth(bitmap, size);
        else return resizeByHeight(bitmap, size);
    }

    private static Bitmap resizeByWidth(Bitmap bitmap, int size) {
        if (size == 0) throw new RuntimeException("size == 0");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < size) return bitmap;

        double resizePercent = 100 - ((size * 100) / width);
        int h = (int) Math.round(height - ((height / 100) * resizePercent));
        return Bitmap.createScaledBitmap(bitmap, size, h, true);
    }

    private static Bitmap resizeByHeight(Bitmap bitmap, int size) {
        if (size == 0) throw new RuntimeException("size == 0");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height < size) return bitmap;

        double resizePercent = 100 - ((size * 100) / height);
        int w = (int) Math.round(width - ((width / 100) * resizePercent));
        return Bitmap.createScaledBitmap(bitmap, w, size, true);
    }

    public static byte[] toBytes(Bitmap bitmap, int quality) {
        if (bitmap == null) {
            return null;
        } else {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream);
            return stream.toByteArray();
        }
    }


}

