package bilgem.nlp.langid;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

public class LanguageIndentifierTest {
    @Test
    public void functionalTest() throws IOException {
        String[] langs = {"en","tr"};
        LanguageIdentifier lid = LanguageIdentifier.generateFromCounts(langs);
        Assert.assertEquals("tr",lid.identifyFull("merhaba dünya ve tüm gezegenler"));
        Assert.assertEquals("en",lid.identifyFull("hello world and all the planets"));
    }

    @Test
    public void functionalTest2() throws IOException {
        String[] langs = {"en","tr"};
        LanguageIdentifier lid = LanguageIdentifier.fromModelGroup("tr_en",langs);
        Assert.assertEquals("tr",lid.identifyFull("merhaba dünya ve tüm gezegenler"));
        Assert.assertEquals("en",lid.identifyFull("hello world and all the planets"));
    }
}
