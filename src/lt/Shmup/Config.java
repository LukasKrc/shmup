package lt.Shmup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Config {
    private JsonObject configMap;
    private static Config config;
    private String configPath = "/config/config.json";
    private String pathDelimiter = "/";
    private Gson gson;

    private static void init() {
        if (config == null) {
            config = new Config();
            JsonParser parser = new JsonParser();
            config.configMap = parser.parse(getConfigReader()).getAsJsonObject();
            config.gson = new Gson();
        }
    }

    private static InputStreamReader getConfigReader() {
        return new InputStreamReader(
            Config.class.getResourceAsStream(config.configPath)
        );
    }

    public static String str(String path) {
        init();
        return config.getNode(path).getAsString();
    }

    public static float flt(String path) {
        init();
        return config.getNode(path).getAsFloat();
    }

    public static int intg(String path) {
        init();
        return config.getNode(path).getAsInt();
    }

    public static HashMap<String, String> map(String path) {
        String[] splitPath = config.getSplitString(path);
        JsonObject node = config.getNodeByDescending(
                splitPath
        ).getAsJsonObject(splitPath[splitPath.length - 1]);

        Type stringStringMap = new TypeToken<HashMap<String, String>>(){}.getType();
        return config.gson.fromJson(node, stringStringMap);
    }

    private JsonPrimitive getNode(String path) {
        String[] explodedPath = getSplitString(path);
        JsonPrimitive node = getNode(explodedPath);

        return node;
    }

    private String[] getSplitString(String path) {
        return path.split(pathDelimiter);
    }

    private JsonPrimitive getNode(String[] explodedPath) {
        if (explodedPath.length == 1) {
            return configMap.getAsJsonPrimitive(explodedPath[0]);
        }
        JsonObject node = getNodeByDescending(explodedPath);
        if (node == null) {
            throw new RuntimeException("Given config path is invalid");
        }

        return node.getAsJsonPrimitive(
            explodedPath[explodedPath.length - 1]
        );
    }

    private JsonObject getNodeByDescending(String[] explodedPath) {
        JsonObject node = configMap.getAsJsonObject(explodedPath[0]);
        for (int i = 1; i < explodedPath.length - 1; i++) {
            node = node.getAsJsonObject(explodedPath[i]);
        }
        return node;
    }
}
