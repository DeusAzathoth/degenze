package org.cthulhu.azathoth.commons;

import java.util.ArrayList;
import java.util.List;

public class Therapy_Costants {

    // Frequenza di somministrazione
    public final static String SID = "sid";
    public final static String BID = "bid";
    public final static String TID = "tid";
    public final static List<String> FREQUENCY_LIST = new ArrayList<String>() {
        {
            add(SID);
            add(BID);
            add(TID);
        }
    };



}
