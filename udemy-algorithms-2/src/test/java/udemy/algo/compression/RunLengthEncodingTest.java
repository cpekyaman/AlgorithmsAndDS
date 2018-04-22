package udemy.algo.compression;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RunLengthEncodingTest extends Assertions {
    private RunLengthEncoding encoding;
    private String rlEncodec;
    private String plain;

    @Before
    public void setup() {
        plain = "AAABBBBCCCCC";
        rlEncodec = "3A4B5C";
        encoding = new RunLengthEncoding();
    }

    @Test
    public void testDecode() {
        assertThat(encoding.decode(rlEncodec)).isEqualTo(plain);
    }

    @Test
    public void testEncode() {
        assertThat(encoding.encode(plain)).isEqualTo(rlEncodec);
    }
}
