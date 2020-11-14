package org.orgname.app.util;

import java.util.ArrayList;
import java.util.List;

public interface StringFilter
{
    public boolean filter(String s);

    public static final StringFilter USER_LOGIN_FILTER = new StringFilter() {
        @Override
        public boolean filter(String s) {
            return s.length() > 3 && s.length() < 21;
        }
    };
}
