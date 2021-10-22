package gitlet;

import java.io.File;
import java.io.Serializable;

public class Blob implements Serializable{
    /** The content in the version of file related to the blob. */
    private String content;
    private String filename;

    /** To create a blob from a file with its name and content. */
    public Blob(String filename) {
        this.content = Utils.readContentsAsString(new File(filename));
        this.filename = filename;
    }

    /** To copy the content of a file to the blob, save it in a new file named
     * as its sha1 hash in a directory dir, and return the file name. */
    public String makeBlob(File dir) {
        Utils.writeObject(Utils.join(dir, Utils.sha1(content)), this);
        return Utils.sha1(content);
    }

    /** To get the content of the blob.*/
    public String getContent() {
        return this.content;
    }
}
