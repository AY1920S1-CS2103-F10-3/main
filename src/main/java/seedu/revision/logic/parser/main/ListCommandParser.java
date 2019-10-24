package seedu.revision.logic.parser.main;

import static seedu.revision.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_DIFFICULTY;

import seedu.revision.logic.commands.Command;
import seedu.revision.logic.commands.main.ListCommand;
import seedu.revision.logic.parser.ArgumentMultimap;
import seedu.revision.logic.parser.ArgumentTokenizer;
import seedu.revision.logic.parser.Parser;
import seedu.revision.logic.parser.ParserUtil;
import seedu.revision.logic.parser.exceptions.ParseException;
import seedu.revision.model.answerable.Difficulty;
import seedu.revision.model.answerable.predicates.CategoryPredicate;
import seedu.revision.model.answerable.predicates.DifficultyPredicate;
import seedu.revision.model.category.Category;

/**
 * Adds a filter to the list command.
 * Can filter by category or difficulty of questions available.
 * Checks whether category or difficulty parsed in is available before executing list command to filter.
 */
public class ListCommandParser implements Parser {
    @Override
    public Command parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CATEGORY, PREFIX_DIFFICULTY);

        CategoryPredicate categoryPredicate = null;
        DifficultyPredicate difficultyPredicate = null;

        if (argMultimap.getValue(PREFIX_CATEGORY).isPresent()) {
            Category categoryToFilter = ParserUtil.parseCategory(argMultimap.getValue(PREFIX_CATEGORY).get());
            categoryPredicate = new CategoryPredicate(categoryToFilter);
        }

        if (argMultimap.getValue(PREFIX_DIFFICULTY).isPresent()) {
            Difficulty difficultyToFilter = ParserUtil.parseDifficulty(argMultimap.getValue(PREFIX_DIFFICULTY).get());
            difficultyPredicate = new DifficultyPredicate(difficultyToFilter);
        }

        return new ListCommand(categoryPredicate, difficultyPredicate);
    }
}
