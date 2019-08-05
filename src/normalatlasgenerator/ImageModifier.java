package normalatlasgenerator;

import normalatlasgenerator.DataStructures.Vector2;
import normalatlasgenerator.DataStructures.SpriteData;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

// proof of concept
// clean this mess l8r
// stringbuilder pls
public class ImageModifier {

    public static void insertNormalsToAtlas(File atlas, List<SpriteData> sdata, String projectInputFolderPath, String normalSuffixString, boolean isAliasing, boolean isHQ) {
        try {
            BufferedImage bimgAtlas = ImageIO.read(atlas);
            Graphics2D g = bimgAtlas.createGraphics();
            if (isHQ) {
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            }
            if (isAliasing) 
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            for (SpriteData sd : sdata) {
                File spriteNormal_f = new File(projectInputFolderPath + File.separator + sd.getName() + normalSuffixString + ".png");
                BufferedImage bimgSpriteNormal = ImageIO.read(spriteNormal_f);
                Vector2 pos = sd.getPosition();
                Vector2 size = sd.getSize();
                if (sd.isRotate()) {
                    g.drawImage(getRotatedImage(bimgSpriteNormal, isAliasing, isHQ), pos.getX(), pos.getY(), size.getY(), size.getX(), null);
                } else {
                    g.drawImage(bimgSpriteNormal, pos.getX(), pos.getY(), size.getX(), size.getY(), null);
                }
                ImageIO.write(bimgAtlas, "PNG", atlas);
            }
            bimgAtlas.flush();
            g.dispose();
        } catch (IOException ex) {
            Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static BufferedImage getRotatedImage(BufferedImage bimg, boolean isAliasing, boolean isHQ) {
        BufferedImage tempBImg = bimg;
        int w = bimg.getWidth();
        int h = tempBImg.getHeight();
        BufferedImage dst = new BufferedImage(h, w, tempBImg.getType());

        AffineTransform xform = new AffineTransform();
        xform.translate(0.5 * h, 0.5 * w);
        xform.rotate(-Math.PI / 2);
        xform.translate(-0.5 * w, -0.5 * h);
        Graphics2D tempG2D = dst.createGraphics();

        if (isHQ) {
            tempG2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            tempG2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        }
        if (isAliasing)
            tempG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        tempG2D.drawImage(tempBImg, xform, null);
        tempG2D.dispose();
        try {
            File tempF = File.createTempFile("temp", null);
            try {
                ImageIO.write(dst, "PNG", tempF);
                tempBImg = ImageIO.read(tempF);
                tempF.deleteOnExit();
                return tempBImg;
            } catch (IOException ex) {
                Logger.getLogger(ImageModifier.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageModifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static File prepareEmptyNormalAtlas(File atlasPhoto, boolean isAlias, boolean isHighQuality) {
        try {
            BufferedImage bimgInput = ImageIO.read(atlasPhoto);
            int width = bimgInput.getWidth();
            int height = bimgInput.getHeight();
            Color canvasColor = new Color(128, 131, 252);

            BufferedImage bimgOutput = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D ig2 = bimgOutput.createGraphics();
            ig2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            ig2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            ig2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ig2.setPaint(canvasColor);
            ig2.fillRect(0, 0, bimgOutput.getWidth(), bimgOutput.getHeight());
            File emptyCanvas = new File(atlasPhoto.getPath().replace(".png", "") + "_normal.png");
            ImageIO.write(bimgOutput, "PNG", emptyCanvas);
            bimgOutput.flush();
            ig2.dispose();
            return emptyCanvas;

        } catch (IOException ex) {
            Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
