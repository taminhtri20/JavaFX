import java.io.Serializable;

public class fileInfo implements Serializable {
    private static final long serializable = 1L;
    private String destinationDirectory;
    private String sourceDirectory;
    private String fileName;
    private long fileSize;
    private int piecesOfFile;
    private int lastByteLength;
    public fileInfo(){}

    public int getPiecesOfFile() {
        return piecesOfFile;
    }

    public long getFileSize() {
        return fileSize;
    }

    public int getLastByteLength() {
        return lastByteLength;
    }

    public static long getSerializable() {
        return serializable;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setPiecesOfFile(int piecesOfFile) {
        this.piecesOfFile = piecesOfFile;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public void setLastByteLength(int lastByteLength) {
        this.lastByteLength = lastByteLength;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

}
