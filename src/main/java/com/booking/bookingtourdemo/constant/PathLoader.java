package com.booking.bookingtourdemo.constant;

import java.lang.reflect.Field;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PathLoader {
    public PathLoader() {
    }

    public static String[] loadPathsFromModule(String module) {
        StringJoiner stringJoiner = new StringJoiner(";");
        Class clazz = EventPath.getInnerClassModuleNameBy(module);
        Field[] fields = clazz.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];

            try {
                stringJoiner.add(field.get(field.getName()).toString());
            } catch (IllegalAccessException | IllegalArgumentException var9) {
                Logger.getLogger(PathLoader.class.getName()).log(Level.SEVERE, (String) null, var9);
            }
        }

        return stringJoiner.toString().split(";");
    }
}
