package normalatlasgenerator.DataStructures;

import java.io.File;

public class AtlasData {

    private final File image;
    private final File metadata;

    public File getImage() {
        return image;
    }

    public File getMetadata() {
        return metadata;
    }

    public AtlasData(File image, File metadata) {
        if (MakeSureAtlasData(image, metadata)) {
            this.image = image;
            this.metadata = metadata;
        } else {
            this.image = null;
            this.metadata = null;
        }
    }

    private boolean MakeSureAtlasData(File i, File m) {
        String imageStr = i.getName();
        String metadataStr = m.getName();
        // Strip suffix
        imageStr = imageStr.substring(0, imageStr.lastIndexOf("."));
        // Strip suffix
        metadataStr = metadataStr.substring(0, metadataStr.lastIndexOf("."));
        // Strip .atlas
        metadataStr = metadataStr.substring(0, metadataStr.lastIndexOf("."));
        return i.exists() && m.exists() && imageStr.equals(metadataStr);
    }
}
