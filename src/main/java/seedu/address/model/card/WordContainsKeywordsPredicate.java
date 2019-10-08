package seedu.address.model.card;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Card}'s {@code Word} matches any of the keywords given.
 */
public class WordContainsKeywordsPredicate implements Predicate<Card> {
    private final List<String> keywords;

    public WordContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Card card) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsSubstringIgnoreCase(card.getWord().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof WordContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((WordContainsKeywordsPredicate) other).keywords)); // state check
    }

}
