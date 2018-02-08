package utils;

import enums.Key;

import java.util.HashMap;
import java.util.Map;

public class Session {
     static private Map<Key, Object> storageMap = new HashMap<Key, Object>();

     static public void put(final Key key, final Object value){
         storageMap.put(key, value);
     }

     static public Object get(final Key key){
        return storageMap.get(key);
     }

    static public String getS(final Key key){
        return (String)storageMap.get(key);
    }

}
