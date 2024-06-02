package org.victor.perez.utils;

public class ImageIdExtractor {

    public static String extractImageId(String url) {
        int lastSlashIndex = url.lastIndexOf('/');
        int dotIndex = url.lastIndexOf('.');
        if (lastSlashIndex != -1 && dotIndex != -1 && dotIndex > lastSlashIndex) {
            return url.substring(lastSlashIndex + 1, dotIndex);
        }
        return null;
    }
}