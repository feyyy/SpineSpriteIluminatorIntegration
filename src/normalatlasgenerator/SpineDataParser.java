package normalatlasgenerator;

import normalatlasgenerator.DataStructures.Vector2;
import normalatlasgenerator.DataStructures.SpriteData;
import normalatlasgenerator.DataStructures.AtlasData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpineDataParser {

    public static HashMap<String, ArrayList<SpriteData>> parse(List<AtlasData> data, ArrayList<String> searchThese) {
        Scanner sc;
        String line;
        HashMap<String, ArrayList<SpriteData>> spriteDataMap = new HashMap<>();

        for (AtlasData ad : data) {
            try {
                ArrayList<SpriteData> spriteDatas = new ArrayList<>();
                sc = new Scanner(ad.getMetadata());
                try {
                    String atlasKey = ad.getImage().getCanonicalPath();
                    while (sc.hasNextLine()) {
                        line = sc.nextLine();
                        for (String s : searchThese) {
                            if (line.equals(s)) {
                                // parser logic
                                String _name = line.trim();

                                boolean _rotate = "true".equals(sc.nextLine().replace("  rotate: ", "").trim());

                                String[] posStrings = sc.nextLine().replace("  xy: ", "").trim().split(", ");
                                Vector2 _position = new Vector2(Integer.parseInt(posStrings[0]), Integer.parseInt(posStrings[1]));

                                String[] sizeStrings = sc.nextLine().replace("  size: ", "").trim().split(", ");
                                Vector2 _size = new Vector2(Integer.parseInt(sizeStrings[0]), Integer.parseInt(sizeStrings[1]));

                                String[] originStrings = sc.nextLine().replace("  orig: ", "").trim().split(", ");
                                Vector2 _origin = new Vector2(Integer.parseInt(originStrings[0]), Integer.parseInt(originStrings[1]));

                                String[] offsetStrings = sc.nextLine().replace("  offset: ", "").trim().split(", ");
                                Vector2 _offset = new Vector2(Integer.parseInt(offsetStrings[0]), Integer.parseInt(offsetStrings[1]));

                                int _index = Integer.parseInt(sc.nextLine().replace("  index: ", ""));
                                spriteDatas.add(new SpriteData(_name, _rotate, _position, _size, _origin, _offset, _index));
                            }
                        }
                    }
                    spriteDataMap.put(atlasKey, spriteDatas);

                } catch (IOException ex) {
                    Logger.getLogger(SpineDataParser.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return spriteDataMap;
    }
}
