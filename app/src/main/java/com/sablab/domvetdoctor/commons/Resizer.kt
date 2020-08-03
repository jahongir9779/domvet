package com.sablab.domvetdoctor.commons

import android.graphics.Bitmap
import com.sablab.domvetdoctor.commons.ImageUtils.getScaledBitmap
import java.io.IOException

/**
 * An image resizing library for Android, which allows you to scale an image file to a smaller or bigger one while keeping the aspect ratio.
 */
class Resizer
/**
 * The constructor to initialize Resizer instance.
 *
 * @param context The global application context. You can get it by getApplicationContext().
 */
{
    private var targetLength = 1080
    private var quality = 80
    private var sourceImage: Bitmap? = null

    /**
     * Set the target length of the image. You only need to specify the target length of the longer side (or either side if it's a square). Resizer will calculate the rest automatically.
     *
     * @param targetLength The target image length in pixel. The default value is 1080.
     * @return This Resizer instance, for chained settings.
     */
    fun setTargetLength(targetLength: Int): Resizer {
        this.targetLength = targetLength.coerceAtLeast(0)
        return this
    }

    /**
     * Set the image quality. The higher value, the better image quality but larger file size. PNG, which is a lossless format, will ignore the quality setting.
     *
     * @param quality The image quality value, ranges from 0 to 100. The default value is 80.
     * @return This Resizer instance, for chained settings.
     */
    fun setQuality(quality: Int): Resizer {
        when {
            quality < 0 -> {
                this.quality = 0
            }
            quality > 100 -> {
                this.quality = 100
            }
            else -> {
                this.quality = quality
            }
        }
        return this
    }

    /**
     * Set the source image file.
     *
     * @param sourceImage The source image file to be resized.
     * @return This Resizer instance, for chained settings.
     */
    fun setSourceImage(sourceImage: Bitmap?): Resizer {
        this.sourceImage = sourceImage
        return this
    }

    /**
     * Get the resized image file.
     *
     * @return The resized image file.
     * @throws IOException
     */
    @get:Throws(IOException::class)
    val resizedImage: Bitmap
        get() = getScaledBitmap(targetLength, sourceImage!!)

}