package miu.rahul.utility;

import java.util.List;

public class JSONUtil {
    public static String convertListToJson(List<? extends Object> objects) {
        // Serialize list to JSON
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < objects.size(); i++) {
            sb.append(objects.get(i).toString());
            if (i < objects.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
