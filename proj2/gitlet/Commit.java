package gitlet;

// TODO: any imports you need here
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable{
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    public String message;

    private Date timestamp;
    public Map<String, String> fileVersion;

    /* TODO: fill in the rest of this class. */

    /** The hashcode of parent Commit. */
    public String parent;

    /** To create the initial Commit when commanding 'init'. */
    public Commit() {
        this.message = "initial commit";
        this.timestamp = new Date(0);
    }

    /** To create a new Commit with a message string and current time. */
    public Commit(String msg) {
        this.message = msg;
        this.timestamp = new Date();
    }

    /** To make the commit, save it in a file named as its sha1 hash in a directory dir,
     *  and return the file name. */
    public String saveCommit(File dir) {
        Utils.writeObject(Utils.join(dir, Utils.sha1(Utils.serialize(this))), this);
        return Utils.sha1(Utils.serialize(this));
    }

    /** To copy the filename-blobhash map from another commit. */
    public void copyFileVersion(Commit other) {
        fileVersion = other.fileVersion;
    }

    /** To add or update a filename-blobhash entry in the map. */
    public void changeFileVersion(String filename, String blobhash) {
        if (fileVersion == null) {
            fileVersion = new HashMap<>();
        }
        fileVersion.put(filename, blobhash);
    }

    /** To remove a filename-blobhash entry in the map. */
    public void removeFile(String filename) {
        fileVersion.remove(filename);
    }

    /** To set the parent of the commit. */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /** To print out the commit id, the time the commit was made, and the commit message. */
    public void printCommit() {
        Utils.message("===");
        Utils.message("commit %s", Utils.sha1(Utils.serialize(this)));
        Utils.message("Date: %S", timestamp.toString());
        Utils.message(message);
        Utils.message("");
    }

}
