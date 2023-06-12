package skypro.teamwork.telegram_bot_for_shelter.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class PhotoCatsReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "photoCatsReport_seq")
    private long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    @Lob
    private byte[] data;
    @OneToOne
    @JoinColumn(name = "catsReport_id")
    private ReportCat reportCat;

    public PhotoCatsReport() {

    }

    public PhotoCatsReport(Long id, String filePath, String mediaType, long fileSize, ReportCat reportCat) {
        this.id = id;
        this.filePath = filePath;
        this.mediaType = mediaType;
        this.fileSize = fileSize;
        this.reportCat = reportCat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ReportCat getReportCat() {
        return reportCat;
    }

    public void setReportCat(ReportCat reportCat) {
        this.reportCat = reportCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoCatsReport)) return false;
        PhotoCatsReport that = (PhotoCatsReport) o;
        return id == that.id && fileSize == that.fileSize && Objects.equals(filePath, that.filePath) && Objects.equals(mediaType, that.mediaType) && Arrays.equals(data, that.data) && Objects.equals(reportCat, that.reportCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, fileSize, mediaType, reportCat);
    }

    @Override
    public String toString() {
        return "PhotoCatsReport{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                ", reportCat=" + reportCat +
                '}';
    }
}
