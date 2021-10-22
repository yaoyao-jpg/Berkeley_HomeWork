package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        if (args.length == 0) {
            Utils.error("Please enter a command.");
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                Command.initCommand(args);
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                Command.addCommand(args);
                break;
            // TODO: FILL THE REST IN
            case "commit":
                Command.commitCommand(args);
                break;
            case "rm":
                Command.rmCommand(args);
                break;
            case "log": // have not finished merged information
                Command.logCommand(args);
                break;
            case "global-log":
                Command.globalLogCommand(args);
                break;
            case "find":
                Command.findCommand(args);
                break;
            case "checkout":
                Command.checkoutCommand(args);
                break;
            default:
                throw Utils.error("No command with that name exists.");
        }
    }
}
