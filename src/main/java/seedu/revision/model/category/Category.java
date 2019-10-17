package seedu.revision.model.category;

import static java.util.Objects.requireNonNull;
import static seedu.revision.commons.util.AppUtil.checkArgument;

/**
 * Represents a category in the revision tool.
 * Guarantees: immutable; name is valid as declared in {@link #isValidCategoryName(String)}
 */
public class Category {

    public static final String MESSAGE_CONSTRAINTS = "Category names should not be blank";
    public static final String VALIDATION_REGEX = "^(?=\\s*\\S).*$";

    public final String categoryName;

    /**
     * Constructs a {@code category}.
     *
     * @param categoryName A valid category name.
     */
    public Category(String categoryName) {
        requireNonNull(categoryName);
        checkArgument(isValidCategoryName(categoryName), MESSAGE_CONSTRAINTS);
        this.categoryName = categoryName;
    }

    /**
     * Returns true if a given string is a valid category name.
     */
    public static boolean isValidCategoryName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Category // instanceof handles nulls
                && categoryName.equals(((Category) other).categoryName)); // state check
    }

    @Override
    public int hashCode() {
        return categoryName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + categoryName + ']';
    }

}