package algo.ch18;

public final class StringTernarySearchTrie<VAL> extends TernarySearchTrie<String, VAL> {
    @Override
    protected String empty() {
        return "";
    }

    @Override
    protected String concat(String prefix, char c) {
        return prefix + c;
    }
}
