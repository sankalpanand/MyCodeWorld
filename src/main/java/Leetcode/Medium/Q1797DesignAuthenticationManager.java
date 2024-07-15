package Leetcode.Medium;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q1797DesignAuthenticationManager {
    class AuthenticationManager {

        // here true indicates the map entries are in access order.
        private Map<String, Integer> expiry = new LinkedHashMap<>(16, 0.75F, true);
        private int life;

        public AuthenticationManager(int timeToLive) {
            life = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            evictExpired(currentTime);
            expiry.put(tokenId, life + currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            evictExpired(currentTime);
            if (expiry.containsKey(tokenId)) {
                expiry.put(tokenId, life + currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            evictExpired(currentTime);
            return expiry.size();
        }

        private void evictExpired(int currentTime) {
            Iterator<Map.Entry<String, Integer>> iter = expiry.entrySet().iterator();
            while (iter.hasNext() && iter.next().getValue() <= currentTime) {
                iter.remove();
            }
        }
    }
}
