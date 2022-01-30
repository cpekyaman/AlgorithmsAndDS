package algo.ch18;

public final class StringRWayTrie<VAL> extends RWayTrie<String, VAL> {
    public StringRWayTrie() {
        super(256);
    }

    @Override
    protected String empty() {
        return "";
    }

    @Override
    protected String concat(String prefix, char c) {
        return prefix + c;
    }
}
