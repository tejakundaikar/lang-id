package bilgem.nlp.langid;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;

public enum Language {
    AR, AZ,
    BA, BE, BG, BS,
    CA, CE, CK, CS, CV,
    DA, DE, DIQ,
    EL, EN, EO, ES, ET, EU,
    FA, FI, FR,
    HE, HI, HR, HU, HY,
    ID, IS, IT,
    JA, JV,
    KA, KK, KM, KO, KU, KY,
    LA, LT, LV,
    ML, MN, MS, MY,
    NL, NO,
    PL, PT,
    RO, RU,
    SK, SL, SR, SV,
    TR,
    UK, UZ,
    VI,
    WAR,
    ZH;

    String id;

    private Language() {
        this.id = name().toLowerCase(Locale.ENGLISH);
    }

    public static Language getByName(String input) {
        for (Language language : Language.values()) {
            if (language.id.equalsIgnoreCase(input))
                return language;
        }
        throw new IllegalArgumentException("Cannot find language with name:" + input);
    }

    public static String[] allLanguages() {
        String[] ids = new String[Language.values().length];
        int i = 0;
        for (Language l : Language.values()) {
            ids[i++] = l.id;
        }
        return ids;
    }

    public static Set<String> languageIdSet() {
        return Sets.newLinkedHashSet(Arrays.asList(allLanguages()));
    }
}