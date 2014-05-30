package pl.edu.mimuw.wikiontology.pn347193;

import java.util.Objects;

/**
 * Identifies an article, equivalent with its title.
 */
public final class Identifier implements Comparable<Identifier> {

    public static final Identifier PERSON = new Identifier("Person");
    public static final Identifier PHYSICIST = new Identifier("Physicist");
    public static final Identifier PERSONDATA = new Identifier(
        "Wikipedia:Persondata");
    public static final Identifier TEMPLATES = new Identifier(
        "Wikipedia:Templates");

    private final String normalized;
    private final String lowerCase;

    /**
     * Constructs a normalized identifier from article title.
     *
     * @param title the article title
     */
    public Identifier(String title) {
        normalized = title.trim().intern();
        lowerCase = normalized.toLowerCase().intern();
    }

    /**
     * @return the normalized title.
     */
    @Override
    public String toString() {
        return normalized;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.lowerCase);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Identifier other = (Identifier) obj;
        return Objects.equals(this.lowerCase, other.lowerCase);
    }

    @Override
    public int compareTo(Identifier t) {
        return lowerCase.compareTo(t.lowerCase);
    }

}
