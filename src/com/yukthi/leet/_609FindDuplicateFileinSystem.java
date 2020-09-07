package com.yukthi.leet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class _609FindDuplicateFileinSystem {

    public static void find(Map<String, List<String>> lists, File dir) {
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                find(lists, f);
            } else {
                try {
                    FileInputStream fi = new FileInputStream(f);
                    byte[] fileData = new byte[(int) f.length()];
                    fi.read(fileData);
                    fi.close();
                    //Crearea id unic hash pentru fisierul curent
                    String hash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
                    List<String> list = lists.get(hash);
                    if (list == null) {
                        list = new LinkedList<String>();
                    }
                    //Adăugați calea către listă
                    list.add(f.getAbsolutePath());
                    //Adauga lista actualizată la tabelul Hash
                    lists.put(hash, list);

                } catch (IOException e) {
                    throw new RuntimeException("cannot read file " + f.getAbsolutePath(), e);
                }

            }
        }
    }

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();

        for (String p : paths) {
            String[] data = p.split(" ");

            // System.out.println(Arrays.toString(data));

            String dir = data[0];
            int i = 1;
            while (i < data.length) {
                String[] d = data[i++].split("\\(");

                String file = d[0];
                String content = d[1];


                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }

                List<String> l = map.get(content);
                l.add(dir + "/" + file);
            }
        }

        // System.out.println(map);
        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            List<String> l = map.get(key);
            if (l.size() > 1) {
                result.add(map.get(key));
            }
        }

        // System.out.println(result);
        return result;

    }

    private static MessageDigest messageDigest;
    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize SHA-512 hash function", e);
        }
    }

}
