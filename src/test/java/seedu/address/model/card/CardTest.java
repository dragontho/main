package seedu.address.model.card;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalCards.ABRA;
import static seedu.address.testutil.TypicalCards.BUTTERFREE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.CardBuilder;

public class CardTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Card Card = new CardBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> Card.getTags().remove(0));
    }

    @Test
    public void isSameName() {
        // same object -> returns true
        assertTrue(ABRA.isSameName(ABRA));

        // null -> returns false
        assertFalse(ABRA.isSameName(null));

        // different name -> returns false
        Card editedABRA = new CardBuilder(ABRA).withName(VALID_NAME_BUTTERFREE).build();
        assertFalse(ABRA.isSameName(editedABRA));

        // same name, different attributes -> returns true
        editedABRA = new CardBuilder(ABRA).withDescription(VALID_DESCRIPTION_BUTTERFREE)
                .withTags(VALID_TAG_BUG).build();
        assertTrue(ABRA.isSameName(editedABRA));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Card ABRACopy = new CardBuilder(ABRA).build();
        assertTrue(ABRA.equals(ABRACopy));

        // same object -> returns true
        assertTrue(ABRA.equals(ABRA));

        // null -> returns false
        assertFalse(ABRA.equals(null));

        // different type -> returns false
        assertFalse(ABRA.equals(5));

        // different Card -> returns false
        assertFalse(ABRA.equals(BUTTERFREE));

        // different name -> returns false
        Card editedABRA = new CardBuilder(ABRA).withName(VALID_NAME_BUTTERFREE).build();
        assertFalse(ABRA.equals(editedABRA));

        // different description -> returns false
        editedABRA = new CardBuilder(ABRA).withDescription(VALID_DESCRIPTION_BUTTERFREE).build();
        assertFalse(ABRA.equals(editedABRA));

        // different tags -> returns false
        editedABRA = new CardBuilder(ABRA).withTags(VALID_TAG_BUG).build();
        assertFalse(ABRA.equals(editedABRA));
    }
}
