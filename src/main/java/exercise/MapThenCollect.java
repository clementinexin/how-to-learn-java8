package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by daijiajia on 16/9/1.
 */
public class MapThenCollect {


    public static void main(String[] args) {
        Map<String, List<P>> map = new HashMap();
        List<P> l1 = new ArrayList<>();
        l1.add(new P("a"));
        l1.add(new P("b"));
        l1.add(new P("c"));
        map.put("1", l1);

        System.out.println(map.values().stream().flatMap(ps -> ps.stream()).map(p -> p.getName()).collect(Collectors.toList()));
    }

    static class P {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public P(String name) {
            this.name = name;
        }
    }
}
