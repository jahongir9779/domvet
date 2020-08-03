package com.sablab.domvetdoctor.commons

import android.graphics.Bitmap
import kotlin.math.roundToInt

object ImageUtils {
    @JvmStatic
    fun getScaledBitmap(targetLength: Int, sourceImage: Bitmap): Bitmap {

        // Get the dimensions of the original bitmap
        val originalWidth = sourceImage.width
        val originalHeight = sourceImage.height
        var aspectRatio = originalWidth.toFloat() / originalHeight

        // Calculate the target dimensions
        val targetWidth: Int
        val targetHeight: Int
        if (originalWidth > originalHeight) {
            targetWidth = targetLength
            targetHeight = (targetWidth / aspectRatio).roundToInt()
        } else {
            aspectRatio = 1 / aspectRatio
            targetHeight = targetLength
            targetWidth = (targetHeight / aspectRatio).roundToInt()
        }
        return Bitmap.createScaledBitmap(sourceImage, targetWidth, targetHeight, true)
    }
}