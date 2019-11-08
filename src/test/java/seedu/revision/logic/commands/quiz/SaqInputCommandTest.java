package seedu.revision.logic.commands.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.revision.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.revision.testutil.TypicalAnswerables.J_TF_COMMAND;
import static seedu.revision.testutil.TypicalAnswerables.K_SAQ_COMMAND;

import seedu.revision.logic.commands.Command;
import seedu.revision.logic.commands.main.CommandResult;
import seedu.revision.logic.parser.exceptions.ParseException;
import seedu.revision.model.Model;
import seedu.revision.model.ModelManager;
import seedu.revision.model.answerable.Saq;
import seedu.revision.testutil.builder.SaqBuilder;

public class SaqInputCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();


    private Saq saqTest = new SaqBuilder().build();

    @Test
    public void execute_saqAnswerMatches_correct() throws ParseException {
        Command commandResult = new TfInputCommand(
                "The statement is untrue, both are equally difficult", saqTest);
        CommandResult expectedCommandResult = new CommandResult().withFeedBack("correct")
                .withHelp(false).withExit(false).build();

        try {
            assertCommandSuccess(commandResult, model,
                    expectedCommandResult, expectedModel);
        } catch (Exception e) {
            throw new ParseException(TfInputCommand.MESSAGE_USAGE);
        }
    }

    @Test
    public void execute_saqAnswerRandom_wrong() throws ParseException {
        Command commandResult = new TfInputCommand("I don't know", saqTest);
        CommandResult expectedCommandResult = new CommandResult().withFeedBack("wrong")
                .withHelp(false).withExit(false).build();

        try {
            assertCommandSuccess(commandResult, model,
                    expectedCommandResult, expectedModel);
        } catch (Exception e) {
            throw new ParseException(TfInputCommand.MESSAGE_USAGE);
        }
    }

    @Test
    public void equals() {
        // same values -> returns true
        Command commandCopy = new TfInputCommand("The statement is untrue", saqTest);
        assertTrue(K_SAQ_COMMAND.equals(commandCopy));

        // same object -> returns true
        assertTrue(commandCopy.equals(commandCopy));

        assertFalse(commandCopy.equals(null));

        // different type -> returns false
        assertFalse(commandCopy.equals(10));
        assertFalse(commandCopy.equals("TestString"));
    }
}
