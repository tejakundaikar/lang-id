package bilgem.nlp.langid;

import junit.framework.Assert;
import org.junit.Test;
import smoothnlp.core.io.Files;
import smoothnlp.core.io.SimpleTextReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LanguageIndentifierTest {
    @Test
    public void functionalTest() throws IOException {
        LanguageIdentifier lid = getIdentifierFromInternalCounts();
        Assert.assertEquals("tr", lid.identify("merhaba dünya ve tüm gezegenler"));
        Assert.assertEquals("en", lid.identify("hello world and all the planets"));
    }

    private LanguageIdentifier getIdentifierFromInternalCounts() throws IOException {
        String[] langs = {"en", "tr"};
        return LanguageIdentifier.generateFromCounts(langs);
    }

    @Test
    public void modelGroupTest() throws IOException {
        LanguageIdentifier lid = getTrEnLanguageIdentifier();
        Assert.assertEquals("tr", lid.identify("merhaba dünya ve tüm gezegenler"));
        Assert.assertEquals("en", lid.identify("hello world and all the planets"));
    }

    private LanguageIdentifier getTrEnLanguageIdentifier() throws IOException {
        String[] langs = {"en", "tr"};
        return LanguageIdentifier.fromModelGroup("tr_en", langs);
    }

    @Test
    public void trSiteTest() throws IOException {
        List<File> files = Files.getFilesSorted(new File("src/test/resources/tr"), Files.getNameSortingComparator());
        LanguageIdentifier lid = getTrEnLanguageIdentifier();
        for (File file : files) {
            String content = SimpleTextReader.trimmingUTF8Reader(file).asString();
            List<LanguageIdentifier.IdResult> scores = lid.getScores(content, -1);
            System.out.println("scores for " + file + " = " + scores);
            Assert.assertEquals("tr", scores.get(0).id);
        }
    }

}
